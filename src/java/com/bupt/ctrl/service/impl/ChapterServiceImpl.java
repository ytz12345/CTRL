package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.ChapterMapper;
import com.bupt.ctrl.model.Chapter;
import com.bupt.ctrl.model.ChapterExample;
import com.bupt.ctrl.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public List<Chapter> getChapterOfCourse(Integer course_id){
        ChapterExample courseExample = new ChapterExample();
        ChapterExample.Criteria criteria = courseExample.createCriteria();
        criteria.andCourseCourseIdEqualTo(course_id);
        return chapterMapper.selectByExample(courseExample);
    }

    @Override
    public Chapter getChapter(Integer chapter_id){
        return chapterMapper.selectByPrimaryKey(chapter_id);
    }

    public int addChapter(Chapter chapter){
        chapterMapper.insert(chapter);
        return 1;
    }

    public int modifyChapterVideo(Chapter chapter){
        ChapterExample chapterExample = new ChapterExample();
        ChapterExample.Criteria criteria = chapterExample.createCriteria();

        criteria.andChapterIdEqualTo(chapter.getChapterId());
        chapterMapper.updateByExampleSelective(chapter,chapterExample);
        return 1;
    }
}
