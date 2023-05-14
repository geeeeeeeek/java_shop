package com.test.springdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.springdemo.entity.Comment;
import com.test.springdemo.entity.User;
import com.test.springdemo.mapper.CommentMapper;
import com.test.springdemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    CommentMapper mapper;

    @Override
    public List<Comment> getCommentList() {
        return mapper.getList();
    }

    @Override
    public void createComment(Comment comment) {
        System.out.println(comment);
        comment.setCommentTime(String.valueOf(System.currentTimeMillis()));
        mapper.insert(comment);
    }

    @Override
    public void deleteComment(String id) {
        mapper.deleteById(id);
    }

    @Override
    public void updateComment(Comment comment) {
        mapper.updateById(comment);
    }

    @Override
    public Comment getCommentDetail(String id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Comment> getThingCommentList(String thingId, String order) {
        return mapper.selectThingCommentList(thingId, order);
    }

    @Override
    public List<Comment> getUserCommentList(String thingId) {
        return mapper.selectUserCommentList(thingId);
    }
}
