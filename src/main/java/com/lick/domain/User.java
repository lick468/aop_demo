package com.lick.domain;


import java.io.Serializable;
import java.util.Date;

/**
 * 用户表   user
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6862927937892786281L;
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 用户名 
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 创建时间  修改时间
     */
    private Date createdTime;

    /**
     *   修改时间
     */
    private Date updatedTime;

    /**
     * 获取用户ID
     *
     * @return id - 用户ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户ID
     *
     * @param id 用户ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名 
     *
     * @return username - 用户名 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名 
     *
     * @param username 用户名 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获得创建时间
     *
     * @return createdTime 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获得修改时间
     *
     * @return  updatedTime 修改时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置修改时间
     *
     * @param updatedTime 修改时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}