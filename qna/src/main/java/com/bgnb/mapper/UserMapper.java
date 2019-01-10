package com.bgnb.mapper;

import com.bgnb.pojo.User;
import com.bgnb.pojo.Followu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据ID查询用户信息
     *
     * @param uid
     * @return User
     */
    User getById(@Param("uid") int uid);

    /**
     * 查询关注用户列表
     *
     * @param uid
     * @return
     */
    List<User> getFollowUserList(@Param("uid") int uid);

    /**
     * 增加用户
     *
     * @param user
     */
    void addUser(@Param("user") User user);

    /**
     * 增加关注用户
     *
     * @param uid, ufid
     */
    void addFollowUser(@Param("uid") int uid, @Param("ufid") int ufid);

    /**
     * 根据openid查询用户信息
     *
     * @param openid
     * @return User
     */
    User getByOpenid(@Param("openid") String openid);

    /**
     * 增加用户name和pictureurl信息
     *
     * @param uid, name, pictureurl
     */
    void addUserInfo(@Param("uid") int uid, @Param("name") String name, @Param("pictureurl") String pictureurl);

    /**
     * 取消关注用户
     *
     * @param uid, ufid
     */
    void removeFollowUser(@Param("uid") int uid, @Param("ufid") int ufid);

    /**
     * 增加关注问题
     *
     * @param uid, qid
     */
    void addFollowQuestion(@Param("uid") int uid, @Param("qid") int qid);

    /**
     * 取消关注问题
     *
     * @param uid, qid
     */
    void removeFollowQuestion(@Param("uid") int uid, @Param("qid") int qid);

    /**
     * 查看是否关注问题
     *
     * @param uid, qid
     * @return count
     */
    int checkFollowQuestion(@Param("uid") int uid, @Param("qid") int qid);

    /**
     * 查看是否关注用户
     *
     * @param uid, ufid
     * @return count
     */
    int checkFollowUser(@Param("uid") int uid, @Param("ufid") int ufid);
}
