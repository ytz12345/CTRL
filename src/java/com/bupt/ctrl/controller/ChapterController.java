package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Chapter;
import com.bupt.ctrl.model.Comment;
import com.bupt.ctrl.model.Course;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.service.ChapterService;
import com.bupt.ctrl.service.CommentService;
import com.bupt.ctrl.service.CourseService;
import com.bupt.ctrl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

class CommentAndUser{
    Comment comment;
    User user;

    public CommentAndUser(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
class CommentAndUserAndPreviousUser{
    Comment comment;
    User user;
    User previousUser;

    public CommentAndUserAndPreviousUser(Comment comment, User user, User previousUser) {
        this.comment = comment;
        this.user = user;
        this.previousUser = previousUser;
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public User getPreviousUser() {
        return previousUser;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPreviousUser(User previousUser) {
        this.previousUser = previousUser;
    }
}
class GroupComment{
    CommentAndUser parentCommentAndUser;
    List<CommentAndUserAndPreviousUser> sonCommentAndUser;

    public GroupComment(CommentAndUser parentCommentAndUser, List<CommentAndUserAndPreviousUser> sonCommentAndUser) {
        this.parentCommentAndUser = parentCommentAndUser;
        this.sonCommentAndUser = sonCommentAndUser;
    }

    public CommentAndUser getParentCommentAndUser() {
        return parentCommentAndUser;
    }

    public List<CommentAndUserAndPreviousUser> getSonCommentAndUser() {
        return sonCommentAndUser;
    }

    public void setParentCommentAndUser(CommentAndUser parentCommentAndUser) {
        this.parentCommentAndUser = parentCommentAndUser;
    }

    public void setSonCommentAndUser(List<CommentAndUserAndPreviousUser> sonCommentAndUser) {
        this.sonCommentAndUser = sonCommentAndUser;
    }
}

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
    public String getSingleChapter(@RequestParam(value="chapter_id") Integer chapter_id, Model model){
        Chapter chapter = chapterService.getChapter(chapter_id);
        model.addAttribute("chapter", chapter);
        Course course = courseService.getCourse(chapter.getCourseCourseId());
        model.addAttribute("course", course);
        Integer commentNum = commentService.getCommentNum(chapter_id);
        model.addAttribute("commentNum", commentNum);
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
}
