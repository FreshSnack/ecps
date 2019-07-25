package com.shuiyang.ecps.enumerate;

import lombok.AllArgsConstructor;

/**
 * 访问量统计类型
 * @Author: mxding
 * @Date: 2019-07-25 09:03
 */
@AllArgsConstructor
public enum PageViewType {
    MAIN("main", "主页"),
    APPLY("apply", "申请书");

    /**
     * 代码
     */
    public final String code;

    /**
     * 名称
     */
    public final String name;

    /**
     * 根据code获取枚举
     * @param code
     * @return
     */
    public static PageViewType get(String code) {
        for(PageViewType pageViewType : PageViewType.values()) {
            if(pageViewType.code.equals(code)) {
                return pageViewType;
            }
        }
        return null;
    }
}
