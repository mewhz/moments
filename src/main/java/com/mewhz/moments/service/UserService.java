package com.mewhz.moments.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mewhz.moments.model.entity.User;
import com.mewhz.moments.model.dto.UserLoginDTO;
import com.mewhz.moments.model.vo.UserVO;

public interface UserService extends IService<User> {

    UserLoginDTO login(String username, String password);

    UserVO getUserInfo();

    boolean saveUser(User user);
}