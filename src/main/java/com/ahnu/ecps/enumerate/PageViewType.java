package com.ahnu.ecps.enumerate;

import lombok.AllArgsConstructor;

/**
 * 访问量统计类型
 * @Author: mxding
 * @Date: 2019-07-25 09:03
 */
@AllArgsConstructor
public enum PageViewType {
    HOME("home", "主页"),
    APPLY("apply", "申报书"),
    TEAM("team", "教学团队"),
    OUTLINE("outline", "教学大纲"),
    PLAN("attach/plan", "授课教案"),
    WARE("attach/ware", "教学课件"),
    VIDEO("video", "教学视频"),
    LIBRARY("library", "试题库"),
    FEEDBACK("feedback", "教学反馈"),
    INTRODUCE("introduce", "课程简介"),
    TEACHING("teaching", "教学活动"),
    KNOWLEDGE("knowledge", "科普园地"),
    MESSAGE("message", "访客留言");

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
