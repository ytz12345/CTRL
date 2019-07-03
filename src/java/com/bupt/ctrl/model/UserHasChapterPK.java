package com.bupt.ctrl.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserHasChapterPK implements Serializable {
    private int userUserId;
    private int chapterChapterId;

    @Column(name = "User_User_id")
    @Id
    public int getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(int userUserId) {
        this.userUserId = userUserId;
    }

    @Column(name = "Chapter_Chapter_id")
    @Id
    public int getChapterChapterId() {
        return chapterChapterId;
    }

    public void setChapterChapterId(int chapterChapterId) {
        this.chapterChapterId = chapterChapterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasChapterPK that = (UserHasChapterPK) o;

        if (userUserId != that.userUserId) return false;
        if (chapterChapterId != that.chapterChapterId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userUserId;
        result = 31 * result + chapterChapterId;
        return result;
    }
}
