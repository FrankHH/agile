package com.bgnb.service;

import com.bgnb.pojo.Question;

import java.util.List;

public interface QuestionService {

    /**
     * 根据PID查问题
     *
     * @param qid
     * @return Question
     */
    Question getById(int qid);

    /**
     * 根据UID查问题
     *
     * @param uid
     * @return Question
     */
    List<Question> getByUserId(int uid);

    /**
     * 插入一个问题
     *
     * @param question
     */
    void addQuestion(Question question);

    /**
     * 关闭一个问题
     *
     * @param qid
     */
    void closeQuestion(int qid);

    /**
     * 开启一个问题
     *
     * @param qid
     */
    void openQuestion(int qid);

    /**
     * 删除一个问题
     *
     * @param qid
     */
    void deleteQuestion(int qid);

    /**
     * 查询关注者问题
     *
     * @param uid
     */
    List<Question> getFollowUserQuestion(int uid);

    /**
     * 查询关注问题
     *
     * @param uid
     */
    List<Question> getFollowQuestion(int uid);

    List<Question> getRecentQuestion(int offset);

}
