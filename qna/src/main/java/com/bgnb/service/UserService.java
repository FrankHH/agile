package com.bgnb.service;

import com.bgnb.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查询一个用户
     *
     * @param uid
     * @return User
     */
    User getById(int uid);

    /**
     * 查询关注用户列表
     *
     * @param uid
     * @return
     */
    List<User> getFollowUserList(int uid);

    /**
     * 增加用户
     *
     * @param user
     */
    void addUser(User user);

    /**
     * 增加关注用户
     *
     * @param uid, ufid
     */
    void addFollowUser(int uid, int ufid);

    /**
     * 根据openid查询用户信息
     *
     * @param openid
     * @return User
     */
    User getByOpenid(String openid);

    /**
     * 增加用户name和pictureurl信息
     *
     * @param uid, name, pictureurl
     */
    void addUserInfo(int uid, String name, String pictureurl);

    /**
     * 取消关注用户
     *
     * @param uid, ufid
     */
    void removeFollowUser(int uid, int ufid);

    /**
     * 增加关注问题
     *
     * @param uid, qid
     */
    void addFollowQuestion(int uid, int qid);

    /**
     * 取消关注问题
     *
     * @param uid, qid
     */
    void removeFollowQuestion(int uid, int qid);

    /**
     * 查看是否关注问题
     *
     * @param uid, qid
     * @return count
     */
    int checkFollowQuestion(int uid, int qid);

    /**
     * 查看是否关注用户
     *
     * @param uid, ufid
     * @return count
     */
    int checkFollowUser(int uid, int ufid);

}
