package com.guoyie.www.delivery.easy.util;

/**
 * ============================
 *
 * @创建者 柯军
 * @创建时间 2016/10/25 10:50
 * @描述 ============================
 */
public class BlowfishTools {

    public static String encrypt(String key,String value){
        BlowfishECB bf = new BlowfishECB(key);
        String encrypt = bf.encrypt(value);
        return  encrypt;
    }

    /***
     * BlowfishEncry 加密
     * key 是秘钥
     * value 需要解密的文字
     */

    public static String decrypt(String key,String value){
        BlowfishECB bf = new BlowfishECB(key);
        String decrypt = bf.decrypt(value);
        return  decrypt;
    }
}
