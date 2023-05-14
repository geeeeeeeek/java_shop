package com.test.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springdemo.entity.Tag;
import com.test.springdemo.entity.ThingTag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThingTagMapper extends BaseMapper<ThingTag> {

}
