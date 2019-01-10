package com.bgnb.service;

import com.bgnb.pojo.Answer;

import java.util.List;

public interface AnswerService {

    Answer getById(int aid);

    List<Answer> getByUserId(int uid);

    List<Answer> getByQuestionId(int qid);

    void addAnswer(Answer answer);

    void deleteAnswer(int aid);

    List<Answer> getFollowUserAnswer(int uid);

    List<Answer> getRecentAnswer(int offset);

}
