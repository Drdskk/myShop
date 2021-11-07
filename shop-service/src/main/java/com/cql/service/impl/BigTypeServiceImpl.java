package com.cql.service.impl;

import com.cql.config.MyUUID;
import com.cql.entity.BigType;
import com.cql.entity.SmallType;
import com.cql.mapper.BigTypeMapper;
import com.cql.mapper.SmallTypeMapper;
import com.cql.service.BigTypeService;
import com.cql.config.MyCurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("bigTypeService")
public class BigTypeServiceImpl implements BigTypeService {
    @Autowired
    private BigTypeMapper bigTypeMapper;
    @Autowired
    private SmallTypeMapper smallTypeMapper;

    /**
     * 查询操作
     * @param bigType
     * @return  返回结果——BigType对象的List集合
     */
    @Override
    public List<BigType> getBigTypes(BigType bigType) {
        return bigTypeMapper.getBigTypes(bigType);
    }

    /**
     * 插入/修改操作
     * @param bigType
     * @return  返回结果操作是否成功——0 or 1
     */
    @Override
    public Integer addBigType(BigType bigType) {
        //根据id是否为空判断是插入还是修改操作
        if(bigType.getId().isEmpty()){
            //添加操作
            //设置id,创建时间
            return bigTypeMapper.addBigType(bigType.setId(MyUUID.getUUID()).setCreateTime(MyCurrentTime.getTime()));
        }else{
            //修改操作
            return bigTypeMapper.setBigType(bigType);
        }
    }

    /**
     * 删除操作
     * @param bigType
     * @return  返回删除操作结果 0 or 1
     */
    @Override
    public Integer delBigType(BigType bigType) {
        List<SmallType> smallTypeList=smallTypeMapper.getSmallTypes(new SmallType().setBigTypeId(bigType.getId()));
        for(SmallType smallType:smallTypeList){
            smallTypeMapper.delSmallType(smallType);
        }
        return bigTypeMapper.delBigType(bigType);
    }
}
