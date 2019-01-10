package com.bgnb.mapper;

import com.bgnb.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    /**
     * 根据PID查问题
     *
     * @param qid
     * @return Question
     */
    Question getById(@Param("qid") int qid);

    /**
     * 根据UID查问题
     *
     * @param uid
     * @return Question
     */
    List<Question> getByUserId(@Param("uid") int uid);

    /**
     * 插入一个问题
     *
     * @param question
     */
    void addQuestion(@Param("question") Question question);

    /**
     * 关闭一个问题
     *
     * @param qid
     */
    void closeQuestion(@Param("qid") int qid);

    /**
     * 开启一个问题
     *
     * @param qid
     */
    void openQuestion(@Param("qid") int qid);

    /**
     * 删除一个问题
     *
     * @param qid
     */
    void deleteQuestion(@Param("qid") int qid);

    /**
     * 查询关注者问题
     *
     * @param uid
     */
    List<Question> getFollowUserQuestion(@Param("uid") int uid);

    /**
     * 查询关注问题
     *
     * @param uid
     */
    List<Question> getFollowQuestion(@Param("uid") int uid);

    /**
     * 查询最近的问题
     *
     * @Param offset
     * @return
     */
    List<Question> getRecentQuestion(@Param("offset") int offset);

}
