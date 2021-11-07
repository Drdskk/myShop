package com.cql.service;

import com.cql.entity.Address;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AddressService {
    List<Address> getAddress(Address address);
    Integer addAddress(Address address);
    Integer delAddress(Address address);
}
