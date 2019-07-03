package com.bupt.ctrl.model;

import javax.persistence.*;

@Entity
@Table(name = "user_has_chapter", schema = "sdrb", catalog = "")
@IdClass(UserHasChapterPK.class)
public class UserHasChapter {
    private int userUserId;
    private int chapterChapterId;
    private int userHasLearned;

    @Id
    @Column(name = "User_User_id")
    public int getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(int userUserId) {
        this.userUserId = userUserId;
    }

    @Id
    @Column(name = "Chapter_Chapter_id")
    public int getChapterChapterId() {
        return chapterChapterId;
    }

    public void setChapterChapterId(int chapterChapterId) {
        this.chapterChapterId = chapterChapterId;
    }

    @Basic
    @Column(name = "User_has_Learned")
    public int getUserHasLearned() {
        return userHasLearned;
    }

    public void setUserHasLearned(int userHasLearned) {
        this.userHasLearned = userHasLearned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasChapter that = (UserHasChapter) o;

        if (userUserId != that.userUserId) return false;
        if (chapterChapterId != that.chapterChapterId) return false;
        if (userHasLearned != that.userHasLearned) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userUserId;
        result = 31 * result + chapterChapterId;
        result = 31 * result + userHasLearned;
        return result;
    }
}
