package com.mewhz.moments.constant;

/**
 * @author mewhz
 */
public interface InterceptorsConstant {

    String[] EXCLUDED_PATHS = {
            "/webjars/**",
            "/doc.html",
            "/doc.html/**",
            "/v3/**",
            "/favicon.ico",

            "/user/login",

            "/memo/get",
            "/memo/like",

            "/sysConfig/get",
    };

    String[] ALLOW_PATHS = {
            "/memo/list",

            "/comment/add",

            "/user/profile"
    };
}
