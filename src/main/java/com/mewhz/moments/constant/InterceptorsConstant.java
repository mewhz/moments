package com.mewhz.moments.constant;

public interface InterceptorsConstant {

    String[] EXCLUDED_PATHS = {
            "/webjars/**",
            "/doc.html",
            "/doc.html/**",
            "/v3/**",
            "/favicon.ico",

            "/user/login",

//            "/memo/list",
            "/memo/get",
            "/memo/like",
    };

    String[] ALLOW_PATHS = {
            "/memo/list",
            "/comment/add"
    };
}