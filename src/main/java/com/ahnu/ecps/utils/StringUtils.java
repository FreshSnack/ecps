package com.ahnu.ecps.utils;

import java.io.File;
import java.util.UUID;
import java.util.regex.Matcher;

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

    /**
     * 生成唯一值
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 获取存储附件的默认路径
     * @return
     */
    public static String getAttachRootPath() {
        return getProjectRootPath() + getAttachRelativeRootPath();
    }

    /**
     * 获取项目根路径
     * @return
     */
    public static String getProjectRootPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取附件相对根目录
     * @return
     */
    public static String getAttachRelativeRootPath() {
        return File.separator + "etc" + File.separator + "attach" + File.separator;
    }

    /**
     * 纠正mac和window路径不一致
     * @param filePath
     * @return
     */
    public static String getFilePath(String filePath) {
        return filePath.replaceAll("\\\\|/", Matcher.quoteReplacement(File.separator));
    }

}
