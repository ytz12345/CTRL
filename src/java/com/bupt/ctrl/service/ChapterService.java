package com.bupt.ctrl.service;

import com.bupt.ctrl.model.Chapter;

import java.util.List;

public interface ChapterService {

    public List<Chapter> getChapterOfCourse(Integer course_id);

    public Chapter getChapter(Integer chapter_id);
}
