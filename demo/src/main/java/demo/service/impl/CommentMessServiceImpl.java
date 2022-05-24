package demo.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;

import demo.service.CommentMessService;
import org.springframework.stereotype.Service;

import demo.dao.CommentMessDao;
import demo.entity.CommentMess;

/**
 * (CommentMess)表服务实现类
 *
 * @author makejava
 * @since 2022-01-25 13:50:21
 */
@Service("commentMessService")
public class CommentMessServiceImpl implements CommentMessService {
    @Resource
    private CommentMessDao commentMessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    @Override
    public CommentMess queryById(Long commentId) {
        return this.commentMessDao.queryById(commentId);
    }

    /**
     * 根据发表内容id查询评论消息
     *
     * @param commentMessId
     * @return
     */
    @Override
    public Map<Integer, List<CommentMess>> selectComment(Long commentMessId) {
        List<CommentMess> commentMessList = this.commentMessDao.selectComment(commentMessId);
        Map<Integer, List<CommentMess>> collect = commentMessList.stream().sorted(Comparator.comparing(CommentMess::getCreateDate).reversed())
                .collect(Collectors.groupingBy(CommentMess::getCommentUserId));
        return collect;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<CommentMess> queryAllByLimit(int offset, int limit) {
        return this.commentMessDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param commentMess 实例对象
     * @return 实例对象
     */
    @Override
    public CommentMess insert(CommentMess commentMess) {
        if (!commentMess.getCommentFile().isEmpty()) {
            try {
                byte[] bytes = commentMess.getCommentFile().getBytes();
                commentMess.setCommentFileByte(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.commentMessDao.insert(commentMess);
        commentMess.setCommentFile(null);
        return commentMess;
    }

    /**
     * 修改数据
     *
     * @param commentMess 实例对象
     * @return 实例对象
     */
    @Override
    public CommentMess update(CommentMess commentMess) {
        this.commentMessDao.update(commentMess);
        return this.queryById(commentMess.getCommentId());
    }

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long commentId) {
        return this.commentMessDao.deleteById(commentId) > 0;
    }
}