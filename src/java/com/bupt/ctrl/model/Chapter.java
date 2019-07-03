package com.bupt.ctrl.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chapter {
    private int chapterId;
    private int chapterNum;
    private String chapterName;
    private String chapterVideo;
    private String chapterPpt;
    private String chapterIntro;

    @Id
    @Column(name = "Chapter_id")
    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    @Basic
    @Column(name = "Chapter_Num")
    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    @Basic
    @Column(name = "Chapter_Name")
    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    @Basic
    @Column(name = "Chapter_Video")
    public String getChapterVideo() {
        return chapterVideo;
    }

    public void setChapterVideo(String chapterVideo) {
        this.chapterVideo = chapterVideo;
    }

    @Basic
    @Column(name = "Chapter_PPT")
    public String getChapterPpt() {
        return chapterPpt;
    }

    public void setChapterPpt(String chapterPpt) {
        this.chapterPpt = chapterPpt;
    }

    @Basic
    @Column(name = "Chapter_Intro")
    public String getChapterIntro() {
        return chapterIntro;
    }

    public void setChapterIntro(String chapterIntro) {
        this.chapterIntro = chapterIntro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        if (chapterId != chapter.chapterId) return false;
        if (chapterNum != chapter.chapterNum) return false;
        if (chapterName != null ? !chapterName.equals(chapter.chapterName) : chapter.chapterName != null) return false;
        if (chapterVideo != null ? !chapterVideo.equals(chapter.chapterVideo) : chapter.chapterVideo != null)
            return false;
        if (chapterPpt != null ? !chapterPpt.equals(chapter.chapterPpt) : chapter.chapterPpt != null) return false;
        if (chapterIntro != null ? !chapterIntro.equals(chapter.chapterIntro) : chapter.chapterIntro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chapterId;
        result = 31 * result + chapterNum;
        result = 31 * result + (chapterName != null ? chapterName.hashCode() : 0);
        result = 31 * result + (chapterVideo != null ? chapterVideo.hashCode() : 0);
        result = 31 * result + (chapterPpt != null ? chapterPpt.hashCode() : 0);
        result = 31 * result + (chapterIntro != null ? chapterIntro.hashCode() : 0);
        return result;
    }
}
