package com.miku.util;

import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created with com.miku.util
 * Created by   江洋洋
 * E-mail :     960062036@qq.com
 * Date :       2017/5/12 0012
 * Time :       13:08
 */
@Component
public class Base64Util {
    /**
     * 编码
     * @param bstr
     * @return String
     */
    public static String encode(byte[] bstr){
        return new BASE64Encoder().encode(bstr);
    }

    /**
     * 解码
     * @param str
     * @return string
     */
    public static byte[] decode(String str){
        byte[] bt = null;
        try {
            sun.misc.BASE64Decoder decoder = new BASE64Decoder();
            bt = decoder.decodeBuffer( str );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bt;
    }
}
