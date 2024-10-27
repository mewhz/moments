package com.mewhz.moments;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSignerUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    public void arrayUtilTest() {

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("/upload/866ab02db7ee484599549ab2f2896350");
        arrayList.add("/upload/0e80f608e80c45cf85674aecb4ced7f6");

        System.out.println("ArrayUtil.toString(arrayList) = " + ArrayUtil.toString(arrayList));

    }

}
