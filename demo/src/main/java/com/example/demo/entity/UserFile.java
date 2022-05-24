package com.example.demo.entity;

import java.io.Serializable;

/**
 * (UserFile)实体类
 *
 * @author makejava
 * @since 2022-01-19 20:39:10
 */
public class UserFile implements Serializable {
    private static final long serialVersionUID = -48151346817321561L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 所属评论id
     */
    private Long commentId;
    /**
     * 文件识别号
     */
    private String fileUuid;

    /**
     * 文件目录
     */
    private String filePath;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getFileUuid() {
        return fileUuid;
    }

    public void setFileUuid(String fileUuid) {
        this.fileUuid = fileUuid;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

}