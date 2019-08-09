package com.ahnu.ecps.utils;

import java.util.List;

/**
 * 集合工具类
 * @Author: mxding
 * @Date: 2019-08-09 13:10
 */
public class SetUtils {

    /**
     * 判断列表是否为空
     * @param list
     * @return
     */
    public static boolean isNullList(List<?> list) {
        if(list == null || list.size() == 0) {
            return true;
        }
        return false;
    }
}
