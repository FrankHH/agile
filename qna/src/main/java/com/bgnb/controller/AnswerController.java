package com.bgnb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bgnb.pojo.Answer;
import com.bgnb.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @RequestMapping(value = "/{aid}/getById", method = RequestMethod.GET)
    public @ResponseBody String getById(@PathVariable("aid") int aid){
        Answer answer = answerService.getById(aid);
        String resultAnswer = JSON.toJSONString(answer);
        return resultAnswer;
    }

    @RequestMapping(value = "/{uid}/getByUserId", method = RequestMethod.GET)
    public @ResponseBody String getByUserId(@PathVariable("uid") int uid){
        List<Answer> list = answerService.getByUserId(uid);
        String resultAnswerList = JSON.toJSONString(list);
        return resultAnswerList;
    }

    @RequestMapping(value = "/{qid}/getByQuestionId", method = RequestMethod.GET)
    public @ResponseBody String getByQuestionId(@PathVariable("qid") int qid){
        List<Answer> list = answerService.getByQuestionId(qid);
        String resultAnswerList = JSON.toJSONString(list);
        return resultAnswerList;
    }

    @RequestMapping(value = "/{uid}/{qid}/addAnswer")
    public @ResponseBody String addAnswer(@PathVariable("uid") int uid, @PathVariable("qid") int qid, @RequestBody String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Answer answer = new Answer(uid, qid, jsonObject.getString("content"));
        answerService.addAnswer(answer);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{aid}/deleteAnswer")
    public @ResponseBody String deleteAnswer(@PathVariable("aid") int aid){
        answerService.deleteAnswer(aid);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{uid}/getFollowUserAnswer", method = RequestMethod.GET)
    public @ResponseBody String getFollowUserAnswer(@PathVariable("uid") int uid){
        List<Answer> list = answerService.getFollowUserAnswer(uid);
        if(list.isEmpty()){
            list = answerService.getRecentAnswer(0);
        }
        String resultAnswerList = JSON.toJSONString(list);
        return resultAnswerList;
    }

    @RequestMapping(value="/{offset}/getRecentAnswer", method = RequestMethod.GET)
    public @ResponseBody String getRecentAnswer(@PathVariable("offset") int offset){
        List<Answer> list = answerService.getRecentAnswer(offset);
        String resultAnswerList = JSON.toJSONString(list);
        return resultAnswerList;
    }
}
