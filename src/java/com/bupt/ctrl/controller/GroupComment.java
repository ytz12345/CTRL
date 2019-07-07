package com.bupt.ctrl.controller;

import java.util.List;

public class GroupComment{
    CommentAndUser parentCommentAndUser;
    List<CommentAndUserAndPreviousUser> sonCommentAndUser;

    public GroupComment(CommentAndUser parentCommentAndUser, List<CommentAndUserAndPreviousUser> sonCommentAndUser) {
        this.parentCommentAndUser = parentCommentAndUser;
        this.sonCommentAndUser = sonCommentAndUser;
    }

    public CommentAndUser getParentCommentAndUser() {
        return parentCommentAndUser;
    }

    public List<CommentAndUserAndPreviousUser> getSonCommentAndUser() {
        return sonCommentAndUser;
    }

    public void setParentCommentAndUser(CommentAndUser parentCommentAndUser) {
        this.parentCommentAndUser = parentCommentAndUser;
    }

    public void setSonCommentAndUser(List<CommentAndUserAndPreviousUser> sonCommentAndUser) {
        this.sonCommentAndUser = sonCommentAndUser;
    }
}