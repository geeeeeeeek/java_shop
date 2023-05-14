package com.test.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springdemo.entity.Ad;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdMapper extends BaseMapper<Ad> {

}
