package com.bupt.ctrl.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Comment {
    private int commentId;
    private String commentContent;
    private Timestamp commentTime;
    private Integer commentTo;

    @Id
    @Column(name = "Comment_id")
    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "Comment_Content")
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Basic
    @Column(name = "Comment_Time")
    public Timestamp getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    @Basic
    @Column(name = "Comment_To")
    public Integer getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(Integer commentTo) {
        this.commentTo = commentTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (commentId != comment.commentId) return false;
        if (commentContent != null ? !commentContent.equals(comment.commentContent) : comment.commentContent != null)
            return false;
        if (commentTime != null ? !commentTime.equals(comment.commentTime) : comment.commentTime != null) return false;
        if (commentTo != null ? !commentTo.equals(comment.commentTo) : comment.commentTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commentId;
        result = 31 * result + (commentContent != null ? commentContent.hashCode() : 0);
        result = 31 * result + (commentTime != null ? commentTime.hashCode() : 0);
        result = 31 * result + (commentTo != null ? commentTo.hashCode() : 0);
        return result;
    }
}
