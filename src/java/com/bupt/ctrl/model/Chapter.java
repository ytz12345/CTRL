package com.bupt.ctrl.model;

public class Chapter {
    private Integer chapterId;

    private Integer chapterNum;

    private String chapterName;

    private String chapterVideo;

    private String chapterPpt;

    private Integer courseCourseId;

    private String chapterIntro;

    public Chapter(Integer chapterId, Integer chapterNum, String chapterName, String chapterVideo, String chapterPpt, Integer courseCourseId, String chapterIntro) {
        this.chapterId = chapterId;
        this.chapterNum = chapterNum;
        this.chapterName = chapterName;
        this.chapterVideo = chapterVideo;
        this.chapterPpt = chapterPpt;
        this.courseCourseId = courseCourseId;
        this.chapterIntro = chapterIntro;
    }

    public Chapter() {
        super();
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(Integer chapterNum) {
        this.chapterNum = chapterNum;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public String getChapterVideo() {
        return chapterVideo;
    }

    public void setChapterVideo(String chapterVideo) {
        this.chapterVideo = chapterVideo == null ? null : chapterVideo.trim();
    }

    public String getChapterPpt() {
        return chapterPpt;
    }

    public void setChapterPpt(String chapterPpt) {
        this.chapterPpt = chapterPpt == null ? null : chapterPpt.trim();
    }

    public Integer getCourseCourseId() {
        return courseCourseId;
    }

    public void setCourseCourseId(Integer courseCourseId) {
        this.courseCourseId = courseCourseId;
    }

    public String getChapterIntro() {
        return chapterIntro;
    }

    public void setChapterIntro(String chapterIntro) {
        this.chapterIntro = chapterIntro == null ? null : chapterIntro.trim();
    }
}