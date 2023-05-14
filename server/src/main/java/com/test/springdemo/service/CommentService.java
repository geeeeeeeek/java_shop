package com.test.springdemo.service;


import com.test.springdemo.entity.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> getCommentList();
    void createComment(Comment comment);
    void deleteComment(String id);
    void updateComment(Comment comment);
    Comment getCommentDetail(String id);

    List<Comment> getThingCommentList(String thingId, String order);

    List<Comment> getUserCommentList(String thingId);
}
