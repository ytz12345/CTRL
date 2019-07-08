package com.bupt.ctrl.controller;

import com.bupt.ctrl.model.Comment;
import com.bupt.ctrl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/leaveComment")
    public String leaveComment(Comment comment) {
        if (comment.getUserUserId() == 0) return "no_login";
        if (commentService.insertComment(comment) == 1)
            return "login_success";
        else
            return "login_failure";
    }
}
