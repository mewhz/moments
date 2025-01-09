package com.mewhz.moments.interceptor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.jwt.JWT;
import com.mewhz.moments.exception.BizException;
import com.mewhz.moments.util.UserIdTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

import static com.mewhz.moments.constant.InterceptorsConstant.ALLOW_PATHS;

/**
 * @author mewhz
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("x-api-token");
        String servletPath = request.getServletPath();
        log.info("servletPath = {}", servletPath);
        log.info("token = {}", token);
        if (ObjectUtil.isEmpty(token) && !CollUtil.contains(Arrays.asList(ALLOW_PATHS), servletPath)) {
            throw new BizException("缺少 Token");
        }
        try {
            if (ObjectUtil.isNotEmpty(token)) {
                JWT jwt = JWT.of(token);
                Integer userId = Integer.valueOf(jwt.getPayload("userId").toString());
                UserIdTokenUtil.setUserId(userId);
            }
        } catch (Exception e) {
            log.info("Token错误：{}", e.getMessage(), e);
            throw new BizException("Token 错误");
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) {
        UserIdTokenUtil.removeUserId();
    }
}
