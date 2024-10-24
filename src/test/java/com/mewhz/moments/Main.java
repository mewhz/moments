package com.mewhz.moments;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSignerUtil;

public class Main {

    public static void main(String[] args) {
        // 密钥
        byte[] key = "bc0e1497ff134184bb80880f087107b1".getBytes();

        String token = JWT.create()
                .setPayload("userId", 1)
                .setPayload("username", "admin")
                .setHeader("alg", "HS256")
                .setHeader("typ", "JWT")
                .setKey(key)
                .sign();

        System.out.println("token = " + token);

        token = JWT.create()
                .setPayload("userId", 1)
                .setPayload("username", "admin")
                .setSigner(JWTSignerUtil.none())
                .sign();

        System.out.println("token = " + token);

        token = JWT.create()
                .setPayload("userId", 1)
                .setPayload("username", "admin")
                .setKey(key)
                .sign();

        System.out.println("token = " + token);

    }

}
