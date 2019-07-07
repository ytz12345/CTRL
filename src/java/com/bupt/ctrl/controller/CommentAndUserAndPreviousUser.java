package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Comment;
import com.bupt.ctrl.model.User;

//为ChapterController服务的类
public class CommentAndUserAndPreviousUser{
    Comment comment;
    User user;
    User previousUser;

    public CommentAndUserAndPreviousUser(Comment comment, User user, User previousUser) {
        this.comment = comment;
        this.user = user;
        this.previousUser = previousUser;
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public User getPreviousUser() {
        return previousUser;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPreviousUser(User previousUser) {
        this.previousUser = previousUser;
    }
}