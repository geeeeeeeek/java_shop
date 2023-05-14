package com.test.springdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.springdemo.entity.Notice;
import com.test.springdemo.entity.OpLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OpLogMapper extends BaseMapper<OpLog> {

}
