package com.mewhz.moments.util;

/**
 * @author mewhz
 */
public final class UserIdTokenUtil {
    private static final ThreadLocal<Integer> USER_ID_THREAD_LOCAL = new ThreadLocal<>();

    private UserIdTokenUtil() {
        throw new AssertionError("工具类不能被实例化");
    }

    /**
     * 设置用户id
     *
     * @param userId
     */
    public static void setUserId(Integer userId) {
        USER_ID_THREAD_LOCAL.set(userId);
    }

    /**
     * 获取用户id
     *
     * @return
     */
    public static Integer getUserId() {
        return USER_ID_THREAD_LOCAL.get();
    }

    /**
     * 移除用户id
     */
    public static void removeUserId() {
        USER_ID_THREAD_LOCAL.remove();
    }
}
