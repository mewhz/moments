package com.mewhz.moments.interceptor;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.jwt.JWT;
import com.mewhz.moments.exception.BizException;
import com.mewhz.moments.util.UserIdTokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;

import static com.mewhz.moments.constant.InterceptorsConstant.ALLOW_PATHS;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = request.getHeader("x-api-token");

        String servletPath = request.getServletPath();

        System.out.println("servletPath = " + servletPath);

        System.out.println("token = " + token);

        if (ObjectUtil.isEmpty(token) && !CollUtil.contains(Arrays.asList(ALLOW_PATHS), servletPath)) throw new BizException("缺少 Token");

        try {

            if (ObjectUtil.isNotEmpty(token)) {

                JWT jwt = JWT.of(token);

                Integer userId = Integer.valueOf(jwt.getPayload("userId").toString());

                UserIdTokenUtil.setUserId(userId);

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException("Token 错误");
        }

        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserIdTokenUtil.removeUserId();
    }
}
