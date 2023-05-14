package com.gk.study.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gk.study.entity.VisitData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OverviewMapper extends BaseMapper<Object> {

    List<Object> getPopularThing();
    List<Object> getPopularClassification();
    List<VisitData> getWebVisitData(@Param("day") String day);

}
