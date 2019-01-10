package com.bgnb.service.impl;

import com.bgnb.mapper.UserMapper;
import com.bgnb.pojo.User;
import com.bgnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(int uid) {
        return userMapper.getById(uid);
    }

    @Override
    public List<User> getFollowUserList(int uid) {
        return userMapper.getFollowUserList(uid);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void addFollowUser(int uid, int ufid) {
        userMapper.addFollowUser(uid, ufid);
    }

    @Override
    public User getByOpenid(String openid) {
        return userMapper.getByOpenid(openid);
    }

    @Override
    public void addUserInfo(int uid, String name, String pictureurl) {
        userMapper.addUserInfo(uid, name, pictureurl);
    }

    @Override
    public void removeFollowUser(int uid, int ufid) {
        userMapper.removeFollowUser(uid, ufid);
    }

    @Override
    public void addFollowQuestion(int uid, int qid) {
        userMapper.addFollowQuestion(uid, qid);
    }

    @Override
    public void removeFollowQuestion(int uid, int qid) {
        userMapper.removeFollowQuestion(uid, qid);
    }

    @Override
    public int checkFollowQuestion(int uid, int qid) {
        return userMapper.checkFollowQuestion(uid, qid);
    }

    @Override
    public int checkFollowUser(int uid, int ufid) {
        return userMapper.checkFollowUser(uid, ufid);
    }

}
