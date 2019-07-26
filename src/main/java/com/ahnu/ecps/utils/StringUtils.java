package com.ahnu.ecps.utils;

/**
 * 字符串工具类
 * @Author: mxding
 * @Date: 2019-07-24 10:32
 */
public class StringUtils {

    /**
     * 是否为空字符串
     *
     * @param s
     * @return
     */
    public static boolean isNullString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }
}
