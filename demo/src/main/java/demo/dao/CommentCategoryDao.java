package demo.dao;

import demo.entity.CommentCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 消息类别表(CommentCategory)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-24 21:53:42
 */
@Mapper
public interface CommentCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    CommentCategory queryById(Integer categoryId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CommentCategory> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param commentCategory 实例对象
     * @return 对象列表
     */
    List<CommentCategory> queryAll(CommentCategory commentCategory);

    /**
     * 新增数据
     *
     * @param commentCategory 实例对象
     * @return 影响行数
     */
    int insert(CommentCategory commentCategory);

    /**
     * 修改数据
     *
     * @param commentCategory 实例对象
     * @return 影响行数
     */
    int update(CommentCategory commentCategory);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 影响行数
     */
    int deleteById(Integer categoryId);

    /**
     * 查詢所有
     * @return 对象列表
     */
    List<CommentCategory> selectAll();

}