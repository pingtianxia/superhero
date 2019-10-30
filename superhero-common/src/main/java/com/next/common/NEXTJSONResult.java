package com.next.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @路径: com.next.common.NEXTJSONResult
 * @描述: 自定义响应数据结构
 * @作者: hyp
 * @邮箱: henanyunpingearl@163.com
 * @创建日期: 2019-10-30 14:01
 **/
public class NEXTJSONResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
//    @ApiModelProperty(value = "响应业务状态[200: 成功]")
    private Integer status;

    // 响应消息
//    @ApiModelProperty(value = "响应消息内容，成功：[OK]; 失败：[错误消息]")
    private String msg;

    // 响应中的数据
//    @ApiModelProperty(value = "返回用于业务处理的json数据，可以包装[json][list][String][...]")
    private Object data;

    @JsonIgnore
    private String ok;	// 不使用

    public static NEXTJSONResult build(Integer status, String msg, Object data) {
        return new NEXTJSONResult(status, msg, data);
    }

    public static NEXTJSONResult build(Integer status, String msg, Object data, String ok) {
        return new NEXTJSONResult(status, msg, data, ok);
    }

    public static NEXTJSONResult ok(Object data) {
        return new NEXTJSONResult(data);
    }

    public static NEXTJSONResult ok() {
        return new NEXTJSONResult(null);
    }

    public static NEXTJSONResult errorMsg(String msg) {
        return new NEXTJSONResult(500, msg, null);
    }

    public static NEXTJSONResult errorMap(Object data) {
        return new NEXTJSONResult(501, "error", data);
    }

    public static NEXTJSONResult errorTokenMsg(String msg) {
        return new NEXTJSONResult(502, msg, null);
    }

    public static NEXTJSONResult errorException(String msg) {
        return new NEXTJSONResult(555, msg, null);
    }

    public static NEXTJSONResult errorUserQQ(String msg) {
        return new NEXTJSONResult(556, msg, null);
    }

    public NEXTJSONResult() {

    }

    public NEXTJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public NEXTJSONResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public NEXTJSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}
