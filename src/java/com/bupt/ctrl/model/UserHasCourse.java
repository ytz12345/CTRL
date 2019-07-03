package com.bupt.ctrl.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_has_course", schema = "sdrb", catalog = "")
public class UserHasCourse {
    private int userTeachorstudy;

    @Basic
    @Column(name = "User_Teachorstudy")
    public int getUserTeachorstudy() {
        return userTeachorstudy;
    }

    public void setUserTeachorstudy(int userTeachorstudy) {
        this.userTeachorstudy = userTeachorstudy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasCourse that = (UserHasCourse) o;

        if (userTeachorstudy != that.userTeachorstudy) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userTeachorstudy;
    }
}
