package com.cql.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cql.entity.Address;

import java.util.List;

public interface AddressMapper extends BaseMapper<Address> {
    List<Address> getAddress(Address address);
//    List<Address> getAddress(Address address);
//    Integer addAddress(Address address);
//    Integer setAddress(Address address);
//    Integer delAddress(Address address);
}
