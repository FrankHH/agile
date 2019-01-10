package com.bgnb.mapper;

import com.bgnb.pojo.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AnswerMapper {

    /**
     * 根据AID查答案
     *
     * @param aid
     * @return Question
     */
    Answer getById(@Param("aid") int aid);

    /**
     * 根据UID查答案
     *
     * @param uid
     * @return Question
     */
    List<Answer> getByUserId(@Param("uid") int uid);

    /**
     * 根据QID查答案
     *
     * @param qid
     * @return Question
     */
    List<Answer> getByQuestionId(@Param("qid") int qid);

    /**
     * 插入一个答案
     *
     * @param answer
     */
    void addAnswer(@Param("answer") Answer answer);

    /**
     * 删除一个答案
     *
     * @param aid
     */
    void deleteAnswer(@Param("aid") int aid);

    /**
     * 查询关注用户的回答
     *
     * @param uid
     * @return
     */
    List<Answer> getFollowUserAnswer(@Param("uid") int uid);

    /**
     * 查询最近的回答
     *
     * @param offset
     * @return
     */
    List<Answer> getRecentAnswer(@Param("offset") int offset);

}
