package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * (CommentMess)实体类
 *
 * @author makejava
 * @since 2022-01-25 13:50:21
 */
public class CommentMess implements Serializable {
    private static final long serialVersionUID = -48099251291840105L;
    /**
     * 评论id
     */
    private Long commentId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 评论消息id
     */
    private Integer commentMessId;
    /**
     * 被评论用户id
     */
    private Integer commentUserId;
    /**
     * 图片
     */
    private byte[] commentFileByte;
    /**
     * 图片文件
     */
    private MultipartFile commentFile;

    /**
     * 创建时间
     */
    private Date createDate = new Date();


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public MultipartFile getCommentFile() {
        return commentFile;
    }

    public void setCommentFile(MultipartFile commentFile) {
        this.commentFile = commentFile;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentMessId() {
        return commentMessId;
    }

    public void setCommentMessId(Integer commentMessId) {
        this.commentMessId = commentMessId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public byte[] getCommentFileByte() {
        return commentFileByte;
    }

    public void setCommentFileByte(byte[] commentFileByte) {
        this.commentFileByte = commentFileByte;
    }

}