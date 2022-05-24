package demo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserMessage)实体类
 *
 * @author makejava
 * @since 2022-01-19 20:39:11
 */
public class UserMessage implements Serializable {
    private static final long serialVersionUID = 335115146225310989L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 发表时间
     */
    private Date createDate;
    /**
     * 提交记录id
     */
    private Integer publishId;
    /**
     * 版本号
     */
    private Integer versionNumber;
    /**
     * 提交内容
     */
    private String publishContent;
    /**
     * 提交文件
     */
    private String publishFile;
    /**
     * 最后更新时间
     */
    private Date lastUpdate;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getPublishId() {
        return publishId;
    }

    public void setPublishId(Integer publishId) {
        this.publishId = publishId;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getPublishContent() {
        return publishContent;
    }

    public void setPublishContent(String publishContent) {
        this.publishContent = publishContent;
    }

    public String getPublishFile() {
        return publishFile;
    }

    public void setPublishFile(String publishFile) {
        this.publishFile = publishFile;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}