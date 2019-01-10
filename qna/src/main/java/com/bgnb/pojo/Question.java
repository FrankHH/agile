package com.bgnb.pojo;

import java.sql.Timestamp;

public class Question {

    private int qid;
    private int uid;
    private String title;
    private String content;
    private int state; //0 for open, 1 for close
    private Timestamp time;

    private User user;

    public Question() {
    }

    public Question(int uid, String title, String content, int state) {
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.state = state;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
