package com.bgnb.service.impl;

import com.bgnb.mapper.CommentMapper;
import com.bgnb.pojo.Comment;
import com.bgnb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getByAnswerId(int aid) {
        return commentMapper.getByAnswerId(aid);
    }

    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    @Override
    public void deleteComment(int cid) {
        commentMapper.deleteComment(cid);
    }

    @Override
    public List<Comment> getReceivedComment(int uid) {
        return commentMapper.getReceivedComment(uid);
    }
}
