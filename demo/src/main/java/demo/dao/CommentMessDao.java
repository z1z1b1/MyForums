package demo.dao;

import demo.VO.CommentVO;
import demo.entity.CommentMess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CommentMess)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-25 13:50:21
 */
@Mapper
public interface CommentMessDao {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    CommentMess queryById(Long commentId);

    /**
     * 根据发表内容id查询评论消息
     *
     * @param commentMessId
     * @return
     */
    List<CommentMess> selectComment(Long commentMessId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CommentMess> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param commentMess 实例对象
     * @return 对象列表
     */
    List<CommentMess> queryAll(CommentMess commentMess);

    /**
     * 新增数据
     *
     * @param commentMess 实例对象
     * @return 影响行数
     */
    int insert(CommentMess commentMess);

    /**
     * 修改数据
     *
     * @param commentMess 实例对象
     * @return 影响行数
     */
    int update(CommentMess commentMess);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    int deleteById(Long commentId);

    /**
     * 查询个类别前十条数据
     *
     * @return 对象列表
     */
    List<CommentVO> queryLimt();

    /**
     * 置顶评论
     *
     * @return 对象列表
     */
    List<CommentVO> selectTop();

    /**
     * 查询所有
     *
     * @return 对象列表
     */
    List<CommentVO> selectAll();

}