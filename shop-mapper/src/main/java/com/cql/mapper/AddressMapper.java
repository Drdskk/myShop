package com.cql.mapper;


import com.cql.entity.Address;

import java.util.List;

public interface AddressMapper {
    List<Address> getAddress(Address address);
    Integer addAddress(Address address);
    Integer setAddress(Address address);
    Integer delAddress(Address address);
}
