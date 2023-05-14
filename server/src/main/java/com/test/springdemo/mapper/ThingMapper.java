package com.test.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springdemo.entity.Banner;
import com.test.springdemo.entity.Thing;
import com.test.springdemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ThingMapper extends BaseMapper<Thing> {
//    List<Thing> getList();
//    boolean update(Thing thing);
}
