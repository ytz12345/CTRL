package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.User;

public class CourseAndTeacher {
    Course course;
    User teacher;

    public CourseAndTeacher(Course course, User teacher) {
        this.course = course;
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
