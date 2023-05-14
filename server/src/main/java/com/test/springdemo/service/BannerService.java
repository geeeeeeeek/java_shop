package com.test.springdemo.service;


import com.test.springdemo.entity.Banner;

import java.util.List;

public interface BannerService {
    List<Banner> getBannerList();
    void createBanner(Banner banner);
    void deleteBanner(String id);

    void updateBanner(Banner banner);
}
