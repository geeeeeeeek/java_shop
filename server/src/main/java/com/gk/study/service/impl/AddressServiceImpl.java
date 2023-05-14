package com.gk.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gk.study.entity.Address;
import com.gk.study.mapper.AddressMapper;
import com.gk.study.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
    @Autowired
    AddressMapper mapper;

    @Override
    public List<Address> getAddressList(String userId) {
        QueryWrapper<Address> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        queryWrapper.orderBy(true, false, "create_time");
        return mapper.selectList(queryWrapper);
    }

    @Override
    public void createAddress(Address address) {
        System.out.println(address);
        address.setCreateTime(String.valueOf(System.currentTimeMillis()));
        mapper.insert(address);
    }

    @Override
    public void deleteAddress(String id) {
        mapper.deleteById(id);
    }

    @Override
    public void updateAddress(Address address) {
        mapper.updateById(address);
    }
}
