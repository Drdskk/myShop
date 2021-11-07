package com.cql.entity;

public class ShopCar {
    private String id;
    private String goodsId;
    private String userId;
    private String num;
    private String delFlag;
    private Goods goods;
    private User user;

    public String getId() {
        return id;
    }

    public ShopCar setId(String id) {
        this.id = id;
        return this;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public ShopCar setGoodsId(String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public ShopCar setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getNum() {
        return num;
    }

    public ShopCar setNum(String num) {
        this.num = num;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public ShopCar setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Goods getGoods() {
        return goods;
    }

    public ShopCar setGoods(Goods goods) {
        this.goods = goods;
        return this;
    }

    public User getUser() {
        return user;
    }

    public ShopCar setUser(User user) {
        this.user = user;
        return this;
    }
}
