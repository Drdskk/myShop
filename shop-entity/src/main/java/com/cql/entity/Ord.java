package com.cql.entity;

public class Ord {
    private String id;
    private String goodsId;
    private String userId;
    private String addressId;
    private String num;
    private String price;
    private String ordNo;
    private String ordState;
    private String createTime;
    private String delFlag;
    private Goods goods;
    private User user;
    private Address address;

    public String getId() {
        return id;
    }

    public Ord setId(String id) {
        this.id = id;
        return this;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public Ord setGoodsId(String goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public Ord setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getAddressId() {
        return addressId;
    }

    public Ord setAddressId(String addressId) {
        this.addressId = addressId;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Ord setNum(String num) {
        this.num = num;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Ord setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getOrdNo() {
        return ordNo;
    }

    public Ord setOrdNo(String ordNo) {
        this.ordNo = ordNo;
        return this;
    }

    public String getOrdState() {
        return ordState;
    }

    public Ord setOrdState(String ordState) {
        this.ordState = ordState;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public Ord setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public Ord setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public Goods getGoods() {
        return goods;
    }

    public Ord setGoods(Goods goods) {
        this.goods = goods;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Ord setUser(User user) {
        this.user = user;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Ord setAddress(Address address) {
        this.address = address;
        return this;
    }
}
