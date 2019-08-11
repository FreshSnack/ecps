package com.ahnu.ecps.utils;

import lombok.Data;

/**
 * Ajax返回
 * @author dingmx
 * @date 2019/7/23 22:25
 */
@Data
public class AjaxReturn {

    /**
     * 0 成功 1失败
     */
    private int code;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据数量
     */
    private Long count = 0L;

    /**
     * 数据
     */
    private Object data;

    /**
     * 成功默认消息
     */
    public static final String SUCCESS = "success";

    public AjaxReturn(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public AjaxReturn(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static AjaxReturn success() {
        return new AjaxReturn(0, SUCCESS);
    }

    public static AjaxReturn success(Object o) {
        return new AjaxReturn(0, o);
    }

    public static AjaxReturn success(Object o, Long count) {
        AjaxReturn ajaxReturn = new AjaxReturn(0, o);
        ajaxReturn.setCount(count);
        return ajaxReturn;
    }

    public static AjaxReturn failure(String msg) {
        return new AjaxReturn(1, msg);
    }
}
