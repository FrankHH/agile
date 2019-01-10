package com.bgnb.mapper;

import com.bgnb.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    /**
     * 根据AID查评论
     *
     * @param aid
     * @return List<Comment>
     */
    List<Comment> getByAnswerId(@Param("aid") int aid);

    /**
     * 插入一个评论
     *
     * @param comment
     */
    void addComment(@Param("comment") Comment comment);

    /**
     * 删除一个评论
     *
     * @param cid
     */
    void deleteComment(@Param("cid") int cid);

    /**
     * 查看我收到的评论
     *
     * @param uid
     * @Return
     */
    List<Comment> getReceivedComment(@Param("uid") int uid);
}
