package com.bupt.ctrl.model;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String commentContent;

    private Date commentTime;

    private Integer commentTo;

    private Integer chapterChapterId;

    private Integer userUserId;

    public Comment(Integer commentId, String commentContent, Date commentTime, Integer commentTo, Integer chapterChapterId, Integer userUserId) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
        this.commentTo = commentTo;
        this.chapterChapterId = chapterChapterId;
        this.userUserId = userUserId;
    }

    public Comment() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(Integer commentTo) {
        this.commentTo = commentTo;
    }

    public Integer getChapterChapterId() {
        return chapterChapterId;
    }

    public void setChapterChapterId(Integer chapterChapterId) {
        this.chapterChapterId = chapterChapterId;
    }

    public Integer getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(Integer userUserId) {
        this.userUserId = userUserId;
    }
}