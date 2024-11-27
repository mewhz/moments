package com.mewhz.moments.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.jwt.JWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mewhz.moments.exception.BizException;
import com.mewhz.moments.mapper.UserMapper;
import com.mewhz.moments.model.entity.User;
import com.mewhz.moments.model.dto.UserLoginDTO;
import com.mewhz.moments.model.vo.UserVO;
import com.mewhz.moments.service.UserService;
import com.mewhz.moments.util.UserIdTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.mewhz.moments.constant.CommonConstant.KEY;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public UserLoginDTO login(String username, String password) {

        User user = userMapper.selectOne(new QueryWrapper<User>()
                .eq("username", username)
                .eq("password", SecureUtil.md5(password)));

        byte[] key = KEY.getBytes();

        if (user == null) throw new BizException("用户名或密码不正确");

        String token = JWT.create()
                .setPayload("userId", user.getId())
                .setPayload("username", user.getUsername())
                .setHeader("alg", "HS256")
                .setHeader("typ", "JWT")
                .setKey(key)
                .sign();

        UserLoginDTO result = new UserLoginDTO();

        result.setId(user.getId());
        result.setToken(token);
        result.setUsername(user.getUsername());

        System.out.println("result = " + result);

        return result;

    }

    @Override
    public UserVO getUserInfo() {

        Integer userId = UserIdTokenUtil.getUserId();

        User user = userMapper.selectById(userId);

        return BeanUtil.copyProperties(user, UserVO.class);

    }

    @Override
    public boolean saveUser(User user) {

        if (StrUtil.isNotEmpty(user.getPassword()))  user.setPassword(SecureUtil.md5(user.getPassword()));
        else user.setPassword(userMapper.selectById(user.getId()).getPassword());

        return userMapper.updateById(user) > 0;
    }


}
