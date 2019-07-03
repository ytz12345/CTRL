package com.bupt.ctrl.model;

public class User_has_chapter extends User_has_chapterKey {
    private Integer userHasLearned;

    public User_has_chapter(Integer userUserId, Integer chapterChapterId, Integer userHasLearned) {
        super(userUserId, chapterChapterId);
        this.userHasLearned = userHasLearned;
    }

    public User_has_chapter() {
        super();
    }

    public Integer getUserHasLearned() {
        return userHasLearned;
    }

    public void setUserHasLearned(Integer userHasLearned) {
        this.userHasLearned = userHasLearned;
    }
}