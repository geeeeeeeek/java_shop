package com.test.springdemo.service;


import com.test.springdemo.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTagList();
    void createTag(Tag tag);
    void deleteTag(String id);

    void updateTag(Tag tag);
}
