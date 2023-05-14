package com.gk.study.service;


import com.gk.study.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTagList();
    void createTag(Tag tag);
    void deleteTag(String id);

    void updateTag(Tag tag);
}
