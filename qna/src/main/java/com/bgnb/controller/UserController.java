package com.bgnb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bgnb.pojo.User;
import com.bgnb.service.UserService;
import com.bgnb.util.WechatStruct;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{uid}/getUserInfo", method = RequestMethod.GET)
    public @ResponseBody String getById(@PathVariable("uid") int uid){
        User user = userService.getById(uid);
        String resultUser = JSON.toJSONString(user);
        return resultUser;
    }

    @RequestMapping(value = "/{uid}/getFollowUserList", method = RequestMethod.GET)
    public @ResponseBody String getFollowUserList(@PathVariable("uid") int uid){
        List<User> list = userService.getFollowUserList(uid);
        String resultUserList = JSON.toJSONString(list);
        return resultUserList;
    }

    @RequestMapping(value = "/{uid}/addUserInfo")
    public @ResponseBody String addUserInfo(@PathVariable("uid") int uid, @RequestBody String json){
        System.out.println(json);
        JSONObject jsonObject = JSON.parseObject(json);
        userService.addUserInfo(uid, jsonObject.getString("name"), jsonObject.getString("pictureurl"));
        System.out.println(jsonObject.getString("name") + jsonObject.getString("pictureurl"));
        return "Bgnb!";
    }

    @RequestMapping(value = "/{uid}/{ufid}/addFollowUser")
    public @ResponseBody String addFollowUser(@PathVariable("uid") int uid, @PathVariable("ufid") int ufid){
        userService.addFollowUser(uid, ufid);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{uid}/{ufid}/removeFollowUser")
    public @ResponseBody String removeFollowUser(@PathVariable("uid") int uid, @PathVariable("ufid") int ufid){
        userService.removeFollowUser(uid, ufid);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{uid}/{qid}/addFollowQuestion")
    public @ResponseBody String addFollowQuestion(@PathVariable("uid") int uid, @PathVariable("qid") int qid){
        userService.addFollowQuestion(uid, qid);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{uid}/{qid}/removeFollowQuestion")
    public @ResponseBody String removeFollowQuestion(@PathVariable("uid") int uid, @PathVariable("qid") int qid){
        userService.removeFollowQuestion(uid, qid);
        return "Bgnb!";
    }

    @RequestMapping(value = "/{uid}/{qid}/checkFollowQuestion")
    public @ResponseBody String checkFollowQuestion(@PathVariable("uid") int uid, @PathVariable("qid") int qid){
        int res = userService.checkFollowQuestion(uid, qid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", res);
        String state = JSON.toJSONString(map);
        return state;
    }

    @RequestMapping(value = "/{uid}/{ufid}/checkFollowUser")
    public @ResponseBody String checkFollowUser(@PathVariable("uid") int uid, @PathVariable("ufid") int ufid){
        int res = userService.checkFollowUser(uid, ufid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", res);
        String state = JSON.toJSONString(map);
        return state;
    }

    @RequestMapping(value = "/login")
    public @ResponseBody String login(@RequestBody String codeJson){
        String appId = "wxef51705e058effde";
        String secret = "5cf632ed156f38a514730e981943bd3e";
        JSONObject jsonObject = JSON.parseObject(codeJson);
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId + "&secret=" + secret + "&js_code=" + jsonObject.getString("code") + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        if(responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK)
        {
            String sessionData = responseEntity.getBody();
            Gson gson = new Gson();
            WechatStruct ws = gson.fromJson(sessionData, WechatStruct.class);
            String tempOpenid = ws.getOpenid();
            System.out.println("bgnb!");
            User user = userService.getByOpenid(tempOpenid);
            if(user == null){
                user = new User(tempOpenid);
                userService.addUser(user);
            }
            else{
                System.out.println("bgnbnb!");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("uid", user.getUid());
            map.put("openid", tempOpenid);
            String openid = JSON.toJSONString(map);
            return openid;
        }
        return "null";
    }

    @RequestMapping(value="/adminLogin")
    public @ResponseBody String adminLogin(@RequestBody String json){
        System.out.println(json);
        JSONObject jsonObject = JSON.parseObject(json);
        if(jsonObject.getString("username").equals("wc47501") && jsonObject.getString("password").equals("qqwcb12369")){
            return "Bgnb!";
        }
        else{
            return "?";
        }
    }

}
