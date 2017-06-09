package com.miku.util;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyFactory;

import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

@Component
public class RSATest {

    protected String bytesToString(byte[] encrytpByte) {
        String result = "";
        for (Byte bytes : encrytpByte) {
            result += bytes.toString() + " ";
        }
        return result;
    }

    protected byte[] encrypt(String publicKey, byte[] obj) {
        if (publicKey != null) {
            try {
                byte[] keyBytes = Base64Utils.decode(publicKey);
                X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                Key publicK = keyFactory.generatePublic(x509KeySpec);
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, publicK);
                return cipher.doFinal(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    protected byte[] decrypt(String privateKey, byte[] obj) {
        if (privateKey != null) {
            try {
                byte[] keyBytes = Base64Utils.decode(privateKey);
                PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.DECRYPT_MODE, privateK);
                return cipher.doFinal(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
