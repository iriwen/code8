package com.h3c.encode.encode;

/**
 * Created by lc on 2019/08/13.
 */
public enum EnCodeInfoType {

    AES_SYS_KEY(0, "AES_SYS_KEY"),

    AES(1, "AES"),

    SHA1PRNG(2, "SHA1PRNG"),

    DEFAULT_KEYSEED(3, "abcd1234!@#$"),

    DEFAULT_SECRET_KEY(4, "20190910"),

    UTF8(5, "UTF-8");

    private int code;

    private String name;

    EnCodeInfoType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
