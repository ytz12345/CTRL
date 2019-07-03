package com.bupt.ctrl.model;

import java.util.Date;

public class Course {
    private Integer courseId;

    private String courseName;

    private Integer coursePass;

    private String courseIntro;

    private String courseImage;

    private Date courseDate;

    private String courseTeacher;

    public Course(Integer courseId, String courseName, Integer coursePass, String courseIntro, String courseImage, Date courseDate, String courseTeacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.coursePass = coursePass;
        this.courseIntro = courseIntro;
        this.courseImage = courseImage;
        this.courseDate = courseDate;
        this.courseTeacher = courseTeacher;
    }

    public Course() {
        super();
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Integer getCoursePass() {
        return coursePass;
    }

    public void setCoursePass(Integer coursePass) {
        this.coursePass = coursePass;
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro == null ? null : courseIntro.trim();
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage == null ? null : courseImage.trim();
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher == null ? null : courseTeacher.trim();
    }
}