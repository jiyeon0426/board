package com.sesac.board.comm;

import org.junit.jupiter.api.Test;

class cm_encrypTest {

    @Test
    void encryptSha256() {
        /* 단방향 테스트 */
        Cm_encrypt cmEncrypt = new Cm_encrypt();

        String strName = "1234";
        System.out.println("단방향 : "+cmEncrypt.encryptSha256(strName));
    }

    @Test
    void encryptAes() throws Exception {
        /* 양방향 테스트 */
        Cm_encrypt cmEncrypt = new Cm_encrypt();
        String strKey16 = "ABCdefg123456plm";
        String strName="홍길동 아버지는 누구인가";

        String strValue = cmEncrypt.encryptAes(strName,strKey16);

        System.out.println("양방향 암호화 : "+strValue);
    }

    @Test
    void decryptAes() throws Exception {
        /* 복호화 테스트 */
        Cm_encrypt cmEncrypt = new Cm_encrypt();
        String strKey16 = "ABCdefg123456plm";
        String strName="SPKO6H7KLWeK7A8nyPZDbxUzxsKFauBgef4U+Ac8e2ynxl/4odo0KRYvAAiLEUqD";

        String strValue = cmEncrypt.decryptAes(strName,strKey16);

        System.out.println("양방향 복호화 : "+strValue);
    }
}