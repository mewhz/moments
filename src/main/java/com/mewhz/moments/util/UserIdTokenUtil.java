package com.mewhz.moments.util;

public class UserIdTokenUtil {

    private static final ThreadLocal<Integer> userIdThreadLocal = new ThreadLocal<>();

    public static void setUserId(Integer userId) {
        userIdThreadLocal.set(userId);
    }

    public static Integer getUserId() {
        return userIdThreadLocal.get();
    }

    public static void removeUserId() {
        userIdThreadLocal.remove();
    }

}
