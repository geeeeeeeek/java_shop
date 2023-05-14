package com.gk.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gk.study.entity.OpLog;
import com.gk.study.service.OpLogService;
import com.gk.study.mapper.OpLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpLogServiceImpl extends ServiceImpl<OpLogMapper, OpLog> implements OpLogService {
    @Autowired
    OpLogMapper mapper;

    @Override
    public List<OpLog> getOpLogList() {
        QueryWrapper<OpLog> queryWrapper = new QueryWrapper();
        queryWrapper.orderBy(true, false, "re_time");
        queryWrapper.last("limit 0, 1000"); // 前1000条
        return mapper.selectList(queryWrapper);
    }

    @Override
    public void createOpLog(OpLog opLog) {
        mapper.insert(opLog);
    }

    @Override
    public void deleteOpLog(String id) {
        mapper.deleteById(id);
    }

    @Override
    public void updateOpLog(OpLog opLog) {
        mapper.updateById(opLog);
    }

    @Override
    public List<OpLog> getLoginLogList() {
        QueryWrapper<OpLog> queryWrapper = new QueryWrapper();
        queryWrapper.eq("re_url", "/api/user/userLogin");
        queryWrapper.orderBy(true, false, "re_time");
        queryWrapper.last("limit 0, 1000"); // 前1000条
        return mapper.selectList(queryWrapper);
    }
}
