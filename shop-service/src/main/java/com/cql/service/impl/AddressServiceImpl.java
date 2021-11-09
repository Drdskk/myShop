package com.cql.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cql.config.MyUUID;
import com.cql.entity.Address;
import com.cql.mapper.AddressMapper;
import com.cql.service.AddressService;
import com.cql.config.MyCurrentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 查询操作
     * @param address
     * @return  返回结果——Address对象的List集合
     */
    @Override
//    public List<Address> getAddress(Address address) {
//        return addressMapper.getAddress(address);
//    }
    public List<Address> getAddress(Address address){
        return addressMapper.getAddress(address);
    }

    /**
     * 插入/修改操作
     * @param address
     * @return  返回结果操作是否成功——isZero
     */
    @Override
//    public Integer addAddress(Address address) {
//        //根据id是否为空判断是插入还是修改操作
//        if(address.getId().isEmpty()){
//            //添加操作
//            //设置id,创建时间
//            return addressMapper.addAddress(address.setId(MyUUID.getUUID()).setCreateTime(MyCurrentTime.getTime()));
//        }else{
//            //修改操作
//            return addressMapper.setAddress(address);
//        }
//    }
    public Integer addAddress(Address address){
        if(address.getId().isEmpty()){
            return addressMapper.insert(address
                    .setId(MyUUID.getUUID())
                    .setCreateTime(MyCurrentTime.getTime())
                    .setDelFlag("0"));
        }else{
            return addressMapper.updateById(address);
        }
    }

    /**
     * (逻辑)删除操作
     * @param address
     * @return  返回删除操作结果——isZero
     */
    @Override
//    public Integer delAddress(Address address) {
//        return addressMapper.delAddress(address);
//    }
    public Integer delAddress(Address address){
        return addressMapper.updateById(address.setDelFlag("1"));
    }
}
