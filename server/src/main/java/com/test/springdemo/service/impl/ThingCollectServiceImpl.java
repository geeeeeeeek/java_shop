package com.test.springdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.springdemo.entity.ThingCollect;
import com.test.springdemo.entity.ThingWish;
import com.test.springdemo.mapper.ThingCollectMapper;
import com.test.springdemo.service.ThingCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
class ThingCollectServiceImpl extends ServiceImpl<ThingCollectMapper, ThingCollect> implements ThingCollectService {
    @Autowired
    ThingCollectMapper mapper;

    @Override
    public List<Map> getThingCollectList(String userId) {
        return mapper.getThingCollectList(userId);
    }

    @Override
    public void createThingCollect(ThingCollect thingCollect) {
        mapper.insert(thingCollect);;
    }

    @Override
    public void deleteThingCollect(String id) {
        mapper.deleteById(id);
    }

    @Override
    public ThingCollect getThingCollect(String userId, String thingId) {
        QueryWrapper<ThingCollect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("thing_id", thingId)
                .eq("user_id", userId);
        return mapper.selectOne(queryWrapper);
    }
}
