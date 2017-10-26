package com.lanou.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by dllo on 17/7/26.
 */
public class UUID {

    public static String getUUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获得MD5加密结果，长度32
     */
    public static String getMD5Value(String value) {
        try {
            //1 获得jdk 摘要算法工具类
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            //2 加密指定内容,结果10进制
            byte[] md5ValueByteArray = messageDigest.digest(value.getBytes());
            //3将10进制 修改 16进制
            BigInteger bigInteger = new BigInteger(1, md5ValueByteArray);
            return bigInteger.toString(16);
        } catch (Exception e) {
            //如果有错误不进行加密，理论上不会发生
            return value;
        }
    }
}
