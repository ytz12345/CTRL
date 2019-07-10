package com.bupt.ctrl.service.impl;

import com.bupt.ctrl.dao.CommentMapper;
import com.bupt.ctrl.model.Comment;
import com.bupt.ctrl.model.CommentExample;
import com.bupt.ctrl.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

class CmpComent implements Comparator<Comment>
{
    @Override
    public int compare(Comment c1, Comment c2) {
        return (int) (c1.getCommentTime().getTime() - c2.getCommentTime().getTime());
    }
};

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getParentComment(Integer chapter_id){
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andChapterChapterIdEqualTo(chapter_id);
        criteria.andCommentToEqualTo(0);
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public List<Comment> getSonComment(Integer comment_id){
        PriorityQueue<Comment> commentPriorityQueue = new PriorityQueue<Comment>(50, new CmpComent());
        List<Comment> commentList = new ArrayList<>();
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentToEqualTo(comment_id);
        System.out.println("Comment Id:  "+comment_id);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        for(int i = 0; i < comments.size(); i ++){
            Comment comment = (Comment)comments.get(i);
            commentPriorityQueue.offer(comment);
            System.out.println("Son Comment ID: " + comment.getCommentId());
        }
        while(!commentPriorityQueue.isEmpty()){
            Comment Comment = commentPriorityQueue.poll();
            System.out.println("!!!!" + Comment.getCommentId());
            commentList.add(Comment);
            System.out.println("commentList Size:" + commentList.size());
            CommentExample Example = new CommentExample();
            CommentExample.Criteria Criteria = Example.createCriteria();
            Criteria.andCommentToEqualTo(Comment.getCommentId());
            List<Comment> sonComments = commentMapper.selectByExample(Example);
            for(int j = 0; j < sonComments.size(); j ++) commentPriorityQueue.offer((Comment)sonComments.get(j));
        }
        return commentList;
    }

    @Override
    public Integer getCommentNum(Integer chapter_id){
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andChapterChapterIdEqualTo(chapter_id);
        return commentMapper.countByExample(commentExample);
    }

    @Override
    public Comment getComment(Integer comment_id){
        return commentMapper.selectByPrimaryKey(comment_id);
    }

    @Override
    public int addComment(Comment comment) {
        int result = 1;
        try{
            commentMapper.insert(comment);
        }
        catch (Exception e){
            e.printStackTrace();
            result = 0;
        }
        return result;
    }

    @Override
    public int deleteComment(Integer comment_id){
        PriorityQueue<Comment> commentPriorityQueue = new PriorityQueue<Comment>(50, new CmpComent());
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andCommentToEqualTo(comment_id);
        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        for(int i = 0; i < commentList.size(); i ++) commentPriorityQueue.offer(commentList.get(i));
        while(!commentPriorityQueue.isEmpty()){
            Comment Comment = commentPriorityQueue.poll();
            CommentExample Example = new CommentExample();
            CommentExample.Criteria Criteria = Example.createCriteria();
            Criteria.andCommentToEqualTo(Comment.getCommentId());
            List<Comment> sonComments = commentMapper.selectByExample(Example);
            for(int i = 0; i < sonComments.size(); i ++) commentPriorityQueue.offer(sonComments.get(i));
            commentMapper.deleteByPrimaryKey(Comment.getCommentId());
        }
        return commentMapper.deleteByPrimaryKey(comment_id);
    }

    @Override
    public void deleteCommentByUser(Integer uid){
        System.out.println("try delete");
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andUserUserIdEqualTo(uid);
        commentMapper.deleteByExample(commentExample);
        System.out.println("sd");
    }
}
