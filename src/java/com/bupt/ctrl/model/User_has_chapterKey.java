package com.bupt.ctrl.model;

public class User_has_chapterKey {
    private Integer userUserId;

    private Integer chapterChapterId;

    public User_has_chapterKey(Integer userUserId, Integer chapterChapterId) {
        this.userUserId = userUserId;
        this.chapterChapterId = chapterChapterId;
    }

    public User_has_chapterKey() {
        super();
    }

    public Integer getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(Integer userUserId) {
        this.userUserId = userUserId;
    }

    public Integer getChapterChapterId() {
        return chapterChapterId;
    }

    public void setChapterChapterId(Integer chapterChapterId) {
        this.chapterChapterId = chapterChapterId;
    }
}