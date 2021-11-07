package com.cql.entity;

import java.util.List;

public class Goods {
    private String id;
    private String goodsName;
    private String price;
    private String description;
    private String num;
    private String picture;
    private String manufacturer;
    private String smallTypeId;
    private String createTime;
    private String delFlag;
    private String state;
    private String score;
    private SmallType smallType;

    public String getId() {
        return id;
    }

    public Goods setId(String id) {
        this.id = id;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Goods setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Goods setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Goods setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Goods setNum(String num) {
        this.num = num;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public Goods setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Goods setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getSmallTypeId() {
        return smallTypeId;
    }

    public Goods setSmallTypeId(String smallTypeId) {
        this.smallTypeId = smallTypeId;
        return this;
    }


    public String getCreateTime() {
        return createTime;
    }

    public Goods setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public Goods setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getState() {
        return state;
    }

    public Goods setState(String state) {
        this.state = state;
        return this;
    }

    public String getScore() {
        return score;
    }

    public Goods setScore(String score) {
        this.score = score;
        return this;
    }

    public SmallType getSmallType() {
        return smallType;
    }

    public Goods setSmallType(SmallType smallType) {
        this.smallType = smallType;
        return this;
    }
}
