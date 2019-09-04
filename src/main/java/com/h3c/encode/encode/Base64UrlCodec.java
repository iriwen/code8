package com.h3c.encode.encode;


import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;

public class Base64UrlCodec {

    public static String getAESEncodeInfo(long articleId) {
        String info = "articleId=" + articleId + "&" + "sharerAccid=" + "dsdsd" + "&" +
                "entId=" + 122;
        String key = EnCodeInfoType.DEFAULT_SECRET_KEY.getName();
        Key secretKey = getKey(key);
        String encrypt = encrypt(info, secretKey);
        return encrypt;
    }

    public static Key getKey(String keySeed) {
        if (keySeed == null) {
            keySeed = System.getenv(EnCodeInfoType.AES_SYS_KEY.getName());
        }
        if (keySeed == null || keySeed.trim().length() == 0) {
            keySeed = EnCodeInfoType.DEFAULT_KEYSEED.getName();// 默认种子
        }
        try {
            SecureRandom secureRandom = SecureRandom.getInstance(EnCodeInfoType.SHA1PRNG.getName());
            secureRandom.setSeed(keySeed.getBytes());
            KeyGenerator generator = KeyGenerator.getInstance(EnCodeInfoType.AES.getName());
            generator.init(secureRandom);
            return generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据密钥对指定的明文plainText进行加密.
     *
     * @param plainText 明文
     * @return 加密后的密文.
     */
    public static final String encrypt(String plainText, Key secretKey) {
        try {
            Cipher cipher = Cipher.getInstance(EnCodeInfoType.AES.getName());
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] p = plainText.getBytes(EnCodeInfoType.UTF8.getName());
            byte[] result = cipher.doFinal(p);
            Base64.Encoder encoder = Base64.getUrlEncoder();
            byte[] encode = encoder.encode(result);
            return encoder.encodeToString(encode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据密钥对指定的密文cipherText进行解密.
     *
     * @param cipherText 密文
     * @return 解密后的明文.
     */
    public static final String decrypt(String cipherText, Key secretKey) {

        try {
            Cipher cipher = Cipher.getInstance(EnCodeInfoType.AES.getName());
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            Base64.Decoder urlDecoder = Base64.getUrlDecoder();
            byte[] c = urlDecoder.decode(cipherText);
            byte[] result = cipher.doFinal(c);

            String plainText = new String(result, EnCodeInfoType.UTF8.getName());
            return plainText;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) {
        String ciphertext = "name = hello& address=hangzhou";
        String key = EnCodeInfoType.DEFAULT_SECRET_KEY.getName();
        Key secretKey = getKey(key);

        String origin = encrypt(ciphertext, secretKey);
        String result = decrypt(origin, secretKey);
        String[] split = result.split("&");
        System.out.println(split);
    }


    /*public static String safeTranscode(String source) {
        if (StringUtils.isEmpty(source)) {
            return source;
        } else {
            // +  / = 分别替换为 '-','_',''
            String target = source.replace("+", "-")
                    .replace("/", "_")
                    .substring(0, source.length() - 1);
            return target;
        }
    }

    public static String recoverCipherText(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        } else {
            //'-','_',分别替换为 +  / 并且追加=
            String target = str.replace("-", "+")
                    .replace("_", "/") + "=";
            return target;
        }
    }*/
}
