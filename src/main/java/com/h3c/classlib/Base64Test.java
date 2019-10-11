package com.h3c.classlib;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Base64;

public class Base64Test {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String initString = "share?" + "creator_uid=H19946&" + "release_id=2313";

        String encodeBase64 = Base64.getEncoder().encodeToString(initString.getBytes(Charset.defaultCharset()));

        System.out.println("encode string :" + encodeBase64);

        byte[] decodebBytes = Base64.getDecoder().decode(encodeBase64);

        System.out.println(new String(decodebBytes, Charset.defaultCharset()));

    }
}
