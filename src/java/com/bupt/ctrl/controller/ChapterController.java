package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.*;
import com.bupt.ctrl.common.commonPath;
import com.bupt.ctrl.service.ChapterService;
import com.bupt.ctrl.service.CommentService;
import com.bupt.ctrl.service.CourseService;
import com.bupt.ctrl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    @Autowired
    CommentService commentService;

    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;

    @RequestMapping("/singleChapter")
    public String getSingleChapter(@RequestParam(value="chapter_id") Integer chapter_id,
                                   @RequestParam(value="user_id",required = false) Integer user_id,
                                   @RequestParam(value="teacher_id") Integer teacher_id,
                                   Model model){
        Chapter chapter = chapterService.getChapter(chapter_id);
        model.addAttribute("chapter", chapter);
        Course course = courseService.getCourseByID(chapter.getCourseCourseId());
        model.addAttribute("course", course);
        Integer commentNum = commentService.getCommentNum(chapter_id);
        model.addAttribute("commentNum", commentNum);
        User teacher = userService.getUserByID(teacher_id);
        model.addAttribute("teacher", teacher);
        List<Comment> parentCommentList = commentService.getParentComment(chapter_id);
        System.out.println("parentCommentList Size: " + parentCommentList.size());
        List<GroupComment> groupCommentList = new ArrayList<>();
        for(int i = 0; i < parentCommentList.size(); i ++){
            Comment parentComment = (Comment)parentCommentList.get(i);
            User parentUser = userService.getUserByID(parentComment.getUserUserId());
            CommentAndUser parentCommentAndUser = new CommentAndUser(parentComment, parentUser);
            List<Comment> sonCommentList = commentService.getSonComment(parentComment.getCommentId());
            System.out.println("sonCommentList Size: " + sonCommentList.size());
            List<CommentAndUserAndPreviousUser> sonCommentAndUserList = new ArrayList<>();
            for(int j = 0; j < sonCommentList.size(); j ++){
                Comment sonComment = (Comment)sonCommentList.get(j);
                User sonUser = userService.getUserByID(sonComment.getUserUserId());
                Comment previousComment = commentService.getComment(sonComment.getCommentTo());
                User previousUser = userService.getUserByID(previousComment.getUserUserId());
                CommentAndUserAndPreviousUser sonCommentAndUser = new CommentAndUserAndPreviousUser(sonComment, sonUser, previousUser);
                sonCommentAndUserList.add(sonCommentAndUser);
            }
            System.out.println("Parent:  " + parentCommentAndUser.getUser().getUserId());
            System.out.println("Son:    " + sonCommentAndUserList.size());
            GroupComment groupComment = new GroupComment(parentCommentAndUser, sonCommentAndUserList);
            groupCommentList.add(groupComment);
        }
        model.addAttribute("groupCommentList", groupCommentList);
        System.out.println("groupCommentList Size:    " + groupCommentList.size());
        return "single-chapter";
    }

    //创建课程
    @RequestMapping(value = "/addChapter", method = RequestMethod.POST)
    public ModelAndView addChapter(@RequestParam(value = "course_id")int course_id, @RequestParam("chapterVideoFile") CommonsMultipartFile chapterVideoFile, Chapter chapter, HttpServletRequest request) throws IOException {

        ModelAndView mav = new ModelAndView("添加章节失败");

        String courseImagePath = commonPath.videoPath;//路径修改为服务器地址！！！
        String filename = chapterVideoFile.getOriginalFilename();//获取文件名
        String videoPath = courseImagePath + filename;//图像上传完整路径

        File videoFile = new File(courseImagePath,filename);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）

        if(!videoFile.getParentFile().exists()){
            videoFile.getParentFile().mkdirs();
        }

        chapterVideoFile.transferTo(videoFile);

        chapter.setCourseCourseId(course_id);
        chapter.setChapterVideo(videoPath);

        int flag = 0;
        flag =  chapterService.addChapter(chapter);

        if(flag == 1){
            String c_id = String.valueOf(course_id);//转化course_id类型
            String success = "singleCourse?course_id=" + c_id;
            mav.setViewName("redirect:/" + success);//调用singleCourse
            return mav;
        }
        return mav;
    }

}
