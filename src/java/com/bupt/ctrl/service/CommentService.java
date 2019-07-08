package com.bupt.ctrl.service;

import com.bupt.ctrl.model.Comment;

import java.util.List;

public interface CommentService {

    //根据章节id获得所有母评论
    public List<Comment> getParentComment(Integer chapter_id);

    //根据评论id获得所有子评论
    public List<Comment> getSonComment(Integer comment_id);

    //根据章节id获得该章节的全部评论数量
    public Integer getCommentNum(Integer chapter_id);

    //根据评论id获取评论
    public Comment getComment(Integer comment_id);

    //添加新评论
    public int addComment(Comment comment);

    //删除评论
    public int deleteComment(Integer comment_id);
}
