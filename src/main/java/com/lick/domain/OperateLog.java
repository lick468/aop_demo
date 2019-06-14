package com.lick.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志 operateLog
 *
 */
public class OperateLog implements Serializable {
    private static final long serialVersionUID = -7455161196802116098L;

    /**
     * 日志主键
     */
    private Integer id;

    /**
     * 模块标题
     */
    private String title;

    /**
     * 操作方法
     */
    private String method;

    /**
     * 业务类型
     */
    private String operAction;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 请求连接
     */
    private String operURL;

    /**
     * 主机地址
     */
    private String operIP;

    /**
     * 操作地点
     */
    private String operLocation;
    /**
     * 操作状态
     */
    private String status;
    /**
     * 错误信息
     */
    private String errorMSG;
    /**
     * 操作时间
     */
    private Date operTime;
    /**
     * 操作系统
     */
    private String os;
    /**
     * 浏览器类型
     */
    private String browser;


    public String getOperAction() {
        return operAction;
    }

    public void setOperAction(String operAction) {
        this.operAction = operAction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperURL() {
        return operURL;
    }

    public void setOperURL(String operURL) {
        this.operURL = operURL;
    }

    public String getOperIP() {
        return operIP;
    }

    public void setOperIP(String operIP) {
        this.operIP = operIP;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMSG() {
        return errorMSG;
    }

    public void setErrorMSG(String errorMSG) {
        this.errorMSG = errorMSG;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }


}
