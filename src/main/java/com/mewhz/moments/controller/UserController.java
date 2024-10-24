package com.mewhz.moments.controller;

import com.mewhz.moments.model.entity.User;
import com.mewhz.moments.model.vo.ResultVO;
import com.mewhz.moments.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/login")
    public ResultVO<?> login(@RequestBody User user) {
        return ResultVO.success(userService.login(user.getUsername(), user.getPassword()));
    }

}
