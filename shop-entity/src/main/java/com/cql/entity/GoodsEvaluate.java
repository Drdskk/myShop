package com.cql.entity;

public class GoodsEvaluate {
    private String id;
    private String goodsId;
    private String userId;
    private String content;
    private String picture;
    private String level;
    private Goods goods;
    private User user;

    public String getId() {
        return id;
    }

    public GoodsEvaluate setId(String id) {
        this.id = id;
        return this;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public GoodsEvaluate setGoodsId(String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public GoodsEvaluate setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getContent() {
        return content;
    }

    public GoodsEvaluate setContent(String content) {
        this.content = content;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public GoodsEvaluate setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getLevel() {
        return level;
    }

    public GoodsEvaluate setLevel(String level) {
        this.level = level;
        return this;
    }

    public Goods getGoods() {
        return goods;
    }

    public GoodsEvaluate setGoods(Goods goods) {
        this.goods = goods;
        return this;
    }

    public User getUser() {
        return user;
    }

    public GoodsEvaluate setUser(User user) {
        this.user = user;
        return this;
    }
}
