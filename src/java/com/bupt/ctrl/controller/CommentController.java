package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Comment;
import com.bupt.ctrl.model.User;
import com.bupt.ctrl.service.CommentService;
import com.bupt.ctrl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/leaveComment")
    @ResponseBody
    private String leaveComment(Comment comment, Model model){
        model.addAttribute("chapterId", comment.getChapterChapterId());
        System.out.println("Chapter Id : " + comment.getChapterChapterId());
        model.addAttribute("userId", comment.getUserUserId());
        System.out.println("User Id : " + comment.getUserUserId());
        String returnPage;
        if(comment.getUserUserId() == null){
            returnPage = "no_login";
        }
        else if(commentService.addComment(comment) == 0){
            returnPage = "comment_failure";
        }
        else {
            returnPage = "comment_success";
        }
        return returnPage;
    }

    @RequestMapping("/deleteComment")
    private String deleteComment(@RequestParam(value="comment_id") int comment_id, Model model){
        Comment comment = commentService.getComment(comment_id);
        model.addAttribute("comment", comment);
        User user = userService.getUserByID(comment.getUserUserId());
        model.addAttribute("user", user);
        return "delete-comment";
    }

    @RequestMapping("/deleteCommentConfirm")
    @ResponseBody
    private String deleteCommentConfirm(Comment comment, Model model){
        commentService.deleteComment(comment.getCommentId());
        return "delete_success";
    }
}
