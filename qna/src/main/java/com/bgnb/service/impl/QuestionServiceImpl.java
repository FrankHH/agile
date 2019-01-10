package com.bgnb.service.impl;

import com.bgnb.mapper.QuestionMapper;
import com.bgnb.pojo.Question;
import com.bgnb.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Question getById(int qid) {
        return questionMapper.getById(qid);
    }

    @Override
    public List<Question> getByUserId(int uid) {
        return questionMapper.getByUserId(uid);
    }

    @Override
    public void addQuestion(Question question) {
        questionMapper.addQuestion(question);
    }

    @Override
    public void closeQuestion(int qid) {
        questionMapper.closeQuestion(qid);
    }

    @Override
    public void openQuestion(int qid) {
        questionMapper.openQuestion(qid);
    }

    @Override
    public void deleteQuestion(int qid) {
        questionMapper.deleteQuestion(qid);
    }

    @Override
    public List<Question> getFollowUserQuestion(int uid) {
        return questionMapper.getFollowUserQuestion(uid);
    }

    @Override
    public List<Question> getFollowQuestion(int uid) {
        return questionMapper.getFollowQuestion(uid);
    }

    @Override
    public List<Question> getRecentQuestion(int offset) {
        return questionMapper.getRecentQuestion(offset);
    }
}
