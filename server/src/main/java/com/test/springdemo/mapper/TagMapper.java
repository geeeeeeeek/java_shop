package com.test.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springdemo.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}
