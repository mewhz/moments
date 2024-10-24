package com.mewhz.moments.service.impl;

import cn.hutool.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mewhz.moments.exception.BizException;
import com.mewhz.moments.mapper.UserMapper;
import com.mewhz.moments.model.entity.User;
import com.mewhz.moments.model.vo.UserLoginVO;
import com.mewhz.moments.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.mewhz.moments.constant.CommonConstant.KEY;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserLoginVO login(String username, String password) {

        User user = userMapper.selectOne(new QueryWrapper<User>()
                .eq("username", username)
                .eq("password", password));

        byte[] key = KEY.getBytes();

        if (user == null) throw new BizException("用户名或密码不正确");

        String token = JWT.create()
                .setPayload("userId", user.getId())
                .setPayload("username", user.getUsername())
                .setHeader("alg", "HS256")
                .setHeader("typ", "JWT")
                .setKey(key)
                .sign();

        UserLoginVO result = new UserLoginVO();

        result.setId(user.getId());
        result.setToken(token);
        result.setUsername(user.getUsername());

        System.out.println("result = " + result);

        return result;

    }
}
