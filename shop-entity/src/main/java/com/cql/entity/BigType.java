package com.cql.entity;

public class BigType {
    private String id;
    private String typeName;
    private String createTime;
    private String delFlag;

    public String getId() {
        return id;
    }

    public BigType setId(String id) {
        this.id = id;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public BigType setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public BigType setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public BigType setDelFlag(String delFlag) {
        this.delFlag = delFlag;
        return this;
    }
}
