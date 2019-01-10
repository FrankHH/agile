package com.bgnb.service.impl;

import com.bgnb.mapper.AnswerMapper;
import com.bgnb.pojo.Answer;
import com.bgnb.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public Answer getById(int aid) {
        return answerMapper.getById(aid);
    }

    @Override
    public List<Answer> getByUserId(int uid) {
        return answerMapper.getByUserId(uid);
    }

    @Override
    public List<Answer> getByQuestionId(int qid) {
        return answerMapper.getByQuestionId(qid);
    }

    @Override
    public void addAnswer(Answer answer) {
        answerMapper.addAnswer(answer);
    }

    @Override
    public void deleteAnswer(int aid) {
        answerMapper.deleteAnswer(aid);
    }

    @Override
    public List<Answer> getFollowUserAnswer(int uid) {
        return answerMapper.getFollowUserAnswer(uid);
    }

    @Override
    public List<Answer> getRecentAnswer(int offset) {
        return answerMapper.getRecentAnswer(offset);
    }
}
