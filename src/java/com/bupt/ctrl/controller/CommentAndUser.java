package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Comment;
import com.bupt.ctrl.model.User;

public class CommentAndUser{
    Comment comment;
    User user;

    public CommentAndUser(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }
}