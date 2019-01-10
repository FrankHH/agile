package com.bgnb.service;

import com.bgnb.pojo.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 根据AID查评论
     *
     * @param aid
     * @return Question
     */
    List<Comment> getByAnswerId(int aid);

    /**
     * 插入一个评论
     *
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 删除一个评论
     *
     * @param cid
     */
    void deleteComment(int cid);

    /**
     * 查看我收到的评论
     *
     * @param uid
     * @Return
     */
    List<Comment> getReceivedComment(int uid);

}
