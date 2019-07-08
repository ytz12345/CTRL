package com.bupt.ctrl.service;

import com.bupt.ctrl.model.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getParentComment(Integer chapter_id);

    public List<Comment> getSonComment(Integer comment_id); //子评论 comment_id为母评论的id

    public Integer getCommentNum(Integer chapter_id);

    public Comment getComment(Integer comment_id);

    //添加新评论
    public int addComment(Comment comment);

    //删除评论
    public int deleteComment(Integer comment_id);
}
