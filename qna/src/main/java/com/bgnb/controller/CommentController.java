package com.bgnb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bgnb.pojo.Comment;
import com.bgnb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/{aid}/getByAnswerId", method = RequestMethod.GET)
    public @ResponseBody String getByAnswerId(@PathVariable("aid") int aid){
        List<Comment> list = commentService.getByAnswerId(aid);
        String resultCommentList = JSON.toJSONString(list);
        return resultCommentList;
    }

    @RequestMapping(value = "/{uid}/{aid}/addComment")
    public @ResponseBody String addComment(@PathVariable("uid") int uid, @PathVariable("aid") int aid, @RequestBody String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Comment comment = new Comment(uid, aid, jsonObject.getString("content"));
        commentService.addComment(comment);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{cid}/deleteComment")
    public @ResponseBody String deleteComment(@PathVariable("cid") int cid){
        commentService.deleteComment(cid);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{uid}/getReceivedComment", method = RequestMethod.GET)
    public @ResponseBody String getReceivedComment(@PathVariable("uid") int uid){
        List<Comment> list = commentService.getReceivedComment(uid);
        String resultCommentList = JSON.toJSONString(list);
        return resultCommentList;
    }
}
