package com.sesac.board.comm;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/*
*단방향, 양방향 암호화
*<a href="https://fknd12.tistory.com/76"></a>
*/

/* 단방향 */
public class Cm_encrypt {
    public static String encryptSha256(String value) {

        MessageDigest md;
        StringBuffer sb = new StringBuffer("");

        try {

            md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes());
            byte byteData[] = md.digest();

            for (byte tmpStrByte : byteData) {
                String tmpEncTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);

                sb.append(tmpEncTxt);
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return sb.toString();

    }

    /* 양방향 */
    public static String encryptAes(String str, String key) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encPassword = cipher.doFinal(str.getBytes("UTF-8"));

        String result = Base64.getEncoder().encodeToString(encPassword);

        return result;
    }

    /*
     * password = AES 방식으로 암호화된 암호문
     * key = 암호화시 사용했던 키워드
     */

    /* 복호화 */
    public static String decryptAes(String str, String key) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decPassword = cipher.doFinal(Base64.getDecoder().decode(str));
        String result = new String(decPassword, "UTF-8");

        return result;
    }


}
