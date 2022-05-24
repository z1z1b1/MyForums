package demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 消息类别表(CommentCategory)实体类
 *
 * @author makejava
 * @since 2022-05-24 21:53:42
 */
public class CommentCategory implements Serializable {
    private static final long serialVersionUID = 638768942351811238L;
    /**
    * 类别id
    */
    private Integer categoryId;
    /**
    * 类别名称
    */
    private String categoryName;
    /**
    * 最后修改时间
    */
    private Date lastUpdate;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}