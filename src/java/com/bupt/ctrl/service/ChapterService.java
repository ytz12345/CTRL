package com.bupt.ctrl.service;

import com.bupt.ctrl.model.Chapter;

import java.util.List;

public interface ChapterService {

    //根据课程id获得课程的全部章节
    public List<Chapter> getChapterOfCourse(Integer course_id);

    //根据章节id获得相应章节
    public Chapter getChapter(Integer chapter_id);

    //增加章节
    public int addChapter(Chapter chapter);
}
