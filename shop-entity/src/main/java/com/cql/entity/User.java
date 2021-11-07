package com.cql.entity;

public class User {
    private String id;
    private String userName;
    private String password;
    private String realName;
    private String idCard;
    private String sex;
    private String tel;
    private String createTime;
    private String delFlag;

    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public User setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getIdCard() {
        return idCard;
    }

    public User setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public User setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public User setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public User setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public User setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }
}
