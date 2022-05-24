package demo.service;

import demo.entity.CommentCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 消息类别表(CommentCategory)表服务接口
 *
 * @author makejava
 * @since 2022-05-24 21:53:42
 */
public interface CommentCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    CommentCategory queryById(Integer categoryId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CommentCategory> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param commentCategory 实例对象
     * @return 实例对象
     */
    CommentCategory insert(CommentCategory commentCategory);

    /**
     * 修改数据
     *
     * @param commentCategory 实例对象
     * @return 实例对象
     */
    CommentCategory update(CommentCategory commentCategory);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer categoryId);

    /**
     * 查詢所有
     * @return 对象列表
     */
    List<CommentCategory> selectAll();

}