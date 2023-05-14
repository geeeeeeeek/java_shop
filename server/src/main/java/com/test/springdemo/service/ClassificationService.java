package com.test.springdemo.service;


import com.test.springdemo.entity.Classification;
import com.test.springdemo.entity.Classification;

import java.util.List;

public interface ClassificationService {
    List<Classification> getClassificationList();
    void createClassification(Classification Classification);
    void deleteClassification(String id);

    void updateClassification(Classification Classification);
}
