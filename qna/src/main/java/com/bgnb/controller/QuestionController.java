package com.bgnb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bgnb.pojo.Question;
import com.bgnb.service.QuestionService;
import com.bgnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    //根据QID查找问题，返回问题和对应的用户
    @RequestMapping(value = "/{qid}/getById", method = RequestMethod.GET)
    public @ResponseBody String getById(@PathVariable("qid") int qid){
        Question question = questionService.getById(qid);
        String resultQuestion = JSON.toJSONString(question);
        return resultQuestion;
    }

    @RequestMapping(value = "/{uid}/getByUserId", method = RequestMethod.GET)
    public @ResponseBody String getByUserId(@PathVariable("uid") int uid){
        System.out.println("getByUserId");
        List<Question> list = questionService.getByUserId(uid);
        String resultQuestionList = JSON.toJSONString(list);
        System.out.println(resultQuestionList);
        return resultQuestionList;
    }

    @RequestMapping(value = "/{uid}/addQuestion")
    public @ResponseBody String addQuestion(@PathVariable("uid") int uid, @RequestBody String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Question question = new Question(uid, jsonObject.getString("title"), jsonObject.getString("content"), 0);
        questionService.addQuestion(question);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("qid", question.getQid());
        String qid = JSON.toJSONString(map);
        return qid;
    }

    @RequestMapping(value = "/{uid}/getFollowUserQuestion")
    public @ResponseBody String getFollowUserQuestion(@PathVariable("uid") int uid){
        List<Question> list = questionService.getFollowUserQuestion(uid);
        String resultQuestionList = JSON.toJSONString(list);
        return resultQuestionList;
    }

    @RequestMapping(value = "/{uid}/getFollowQuestion")
    public @ResponseBody String getFollowQuestion(@PathVariable("uid") int uid){
        List<Question> list = questionService.getFollowQuestion(uid);
        String resultQuestionList = JSON.toJSONString(list);
        return resultQuestionList;
    }

    @RequestMapping(value="/{offset}/getRecentQuestion", method = RequestMethod.GET)
    public @ResponseBody String getRecentQuestion(@PathVariable("offset") int offset){
        List<Question> list = questionService.getRecentQuestion(offset);
        String resultQuestionList = JSON.toJSONString(list);
        return resultQuestionList;
    }

    @RequestMapping(value = "/{qid}/closeQuestion")
    public @ResponseBody String closeQuestion(@PathVariable("qid") int qid){
        questionService.closeQuestion(qid);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{qid}/openQuestion")
    public @ResponseBody String openQuestion(@PathVariable("qid") int qid){
        questionService.openQuestion(qid);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{qid}/deleteQuestion")
    public @ResponseBody String deleteQuestion(@PathVariable("qid") int qid){
        questionService.deleteQuestion(qid);
        return "Bgnb!";
    }
}
