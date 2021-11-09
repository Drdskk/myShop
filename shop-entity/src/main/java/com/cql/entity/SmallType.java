package com.cql.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SmallType {
    @TableId("id")
    private String id;
    private String bigTypeId;
    private String typeName;
    private String createTime;
    private String delFlag;
    @TableField(exist = false)
    private BigType bigType;

//    public String getId() {
//        return id;
//    }
//
//    public SmallType setId(String id) {
//        this.id = id;
//        return this;
//    }
//
//    public String getBigTypeId() {
//        return bigTypeId;
//    }
//
//    public SmallType setBigTypeId(String bigTypeId) {
//        this.bigTypeId = bigTypeId;
//        return this;
//    }
//
//    public String getTypeName() {
//        return typeName;
//    }
//
//    public SmallType setTypeName(String typeName) {
//        this.typeName = typeName;
//        return this;
//    }
//
//    public String getCreateTime() {
//        return createTime;
//    }
//
//    public SmallType setCreateTime(String createTime) {
//        this.createTime = createTime;
//        return this;
//    }
//
//    public String getDelFlag() {
//        return delFlag;
//    }
//
//    public SmallType setDelFlag(String delFlag) {
//        this.delFlag = delFlag;
//        return this;
//    }
//
//    public BigType getBigType() {
//        return bigType;
//    }
//
//    public SmallType setBigType(BigType bigType) {
//        this.bigType = bigType;
//        return this;
//    }
}
