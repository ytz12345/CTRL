package com.bupt.ctrl.model;

public class User_has_course {
    private Integer courseCourseId;

    private Integer userTeachorstudy;

    private Integer userUserId;

    public User_has_course(Integer courseCourseId, Integer userTeachorstudy, Integer userUserId) {
        this.courseCourseId = courseCourseId;
        this.userTeachorstudy = userTeachorstudy;
        this.userUserId = userUserId;
    }

    public User_has_course() {
        super();
    }

    public Integer getCourseCourseId() {
        return courseCourseId;
    }

    public void setCourseCourseId(Integer courseCourseId) {
        this.courseCourseId = courseCourseId;
    }

    public Integer getUserTeachorstudy() {
        return userTeachorstudy;
    }

    public void setUserTeachorstudy(Integer userTeachorstudy) {
        this.userTeachorstudy = userTeachorstudy;
    }

    public Integer getUserUserId() {
        return userUserId;
    }

    public void setUserUserId(Integer userUserId) {
        this.userUserId = userUserId;
    }
}