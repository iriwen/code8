package com.h3c.encode;

import java.security.Key;

public class TestAES {

    public static void main(String[] args) {

        String plantext = "articleId=1001&sharerAccid=19946";

        Key secretKey = AESUtil.getKey("20190910");
        String encrypt = AESUtil.encrypt(plantext, secretKey);

        System.out.println(encrypt);

        String decrypt = AESUtil.decrypt(encrypt, secretKey);
        System.out.println(decrypt);
    }

}
