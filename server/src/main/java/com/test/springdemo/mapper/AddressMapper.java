package com.test.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springdemo.entity.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}
