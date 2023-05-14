package com.gk.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gk.study.service.BannerService;
import com.gk.study.entity.Banner;
import com.gk.study.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements BannerService {
    @Autowired
    BannerMapper mapper;

    @Override
    public List<Banner> getBannerList() {
        return mapper.selectList(new QueryWrapper<>());
    }

    @Override
    public void createBanner(Banner banner) {
        System.out.println(banner);
        banner.setCreateTime(String.valueOf(System.currentTimeMillis()));
        mapper.insert(banner);
    }

    @Override
    public void deleteBanner(String id) {
        mapper.deleteById(id);
    }

    @Override
    public void updateBanner(Banner banner) {
        mapper.updateById(banner);
    }
}
