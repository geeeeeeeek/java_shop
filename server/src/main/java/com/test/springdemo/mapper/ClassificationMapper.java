package com.test.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springdemo.entity.Classification;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassificationMapper extends BaseMapper<Classification> {

}
