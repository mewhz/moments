package com.mewhz.moments.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mewhz.moments.model.entity.User;
import com.mewhz.moments.model.vo.UserLoginVO;

public interface UserService extends IService<User> {

    UserLoginVO login(String username, String password);

}