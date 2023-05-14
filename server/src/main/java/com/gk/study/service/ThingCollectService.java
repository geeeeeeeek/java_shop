package com.gk.study.service;


import com.gk.study.entity.ThingCollect;

import java.util.List;
import java.util.Map;

public interface ThingCollectService {
    List<Map> getThingCollectList(String userId);
    void createThingCollect(ThingCollect thingCollect);
    void deleteThingCollect(String id);
    ThingCollect getThingCollect(String userId, String thingId);
}
