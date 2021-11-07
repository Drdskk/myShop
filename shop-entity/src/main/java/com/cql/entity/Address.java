package com.cql.entity;

import java.util.List;

public class Address {
    private String id;
    private String consignee;
    private String consigneeTel;
    private String address;
    private String userId;
    private String createTime;
    private String delFlag;
    private User user;

    public String getId() {
        return id;
    }

    public Address setId(String id) {
        this.id = id;
        return this;
    }

    public String getConsignee() {
        return consignee;
    }

    public Address setConsignee(String consignee) {
        this.consignee = consignee;
        return this;
    }

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public Address setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Address setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Address setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Address setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public Address setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Address setUser(User user) {
        this.user = user;
        return this;
    }
}
