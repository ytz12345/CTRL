package com.bupt.ctrl.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Course {
    private int courseId;
    private String courseName;
    private int coursePass;
    private String courseIntro;
    private String courseImage;
    private Timestamp courseDate;
    private String courseTeacher;

    @Id
    @Column(name = "Course_Id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "Course_Name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "Course_Pass")
    public int getCoursePass() {
        return coursePass;
    }

    public void setCoursePass(int coursePass) {
        this.coursePass = coursePass;
    }

    @Basic
    @Column(name = "Course_Intro")
    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
    }

    @Basic
    @Column(name = "Course_Image")
    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    @Basic
    @Column(name = "Course_Date")
    public Timestamp getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Timestamp courseDate) {
        this.courseDate = courseDate;
    }

    @Basic
    @Column(name = "Course_Teacher")
    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != course.courseId) return false;
        if (coursePass != course.coursePass) return false;
        if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null) return false;
        if (courseIntro != null ? !courseIntro.equals(course.courseIntro) : course.courseIntro != null) return false;
        if (courseImage != null ? !courseImage.equals(course.courseImage) : course.courseImage != null) return false;
        if (courseDate != null ? !courseDate.equals(course.courseDate) : course.courseDate != null) return false;
        if (courseTeacher != null ? !courseTeacher.equals(course.courseTeacher) : course.courseTeacher != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + coursePass;
        result = 31 * result + (courseIntro != null ? courseIntro.hashCode() : 0);
        result = 31 * result + (courseImage != null ? courseImage.hashCode() : 0);
        result = 31 * result + (courseDate != null ? courseDate.hashCode() : 0);
        result = 31 * result + (courseTeacher != null ? courseTeacher.hashCode() : 0);
        return result;
    }
}
