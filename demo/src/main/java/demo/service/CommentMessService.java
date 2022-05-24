package demo.service;

import java.util.List;
import java.util.Map;

import demo.VO.CommentVO;
import demo.entity.CommentMess;
import org.apache.ibatis.annotations.Mapper;

/**
 * (CommentMess)表服务接口
 *
 * @author makejava
 * @since 2022-01-25 13:50:21
 */
public interface CommentMessService {

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
    Map<Integer, List<CommentMess>> selectComment(Long commentMessId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CommentMess> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param commentMess 实例对象
     * @return 实例对象
     */
    CommentMess insert(CommentMess commentMess);

    /**
     * 修改数据
     *
     * @param commentMess 实例对象
     * @return 实例对象
     */
    CommentMess update(CommentMess commentMess);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    boolean deleteById(Long commentId);

    /**
     * 查询个类别前十条数据
     * @return 对象列表
     */
    List<CommentVO> queryLimt();
}