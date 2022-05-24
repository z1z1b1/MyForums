package demo.service.impl;

import demo.dao.CommentCategoryDao;
import demo.entity.CommentCategory;
import demo.service.CommentCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 消息类别表(CommentCategory)表服务实现类
 *
 * @author makejava
 * @since 2022-05-24 21:53:42
 */
@Service("commentCategoryService")
public class CommentCategoryServiceImpl implements CommentCategoryService {
    @Resource
    private CommentCategoryDao commentCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    @Override
    public CommentCategory queryById(Integer categoryId) {
        return this.commentCategoryDao.queryById(categoryId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<CommentCategory> queryAllByLimit(int offset, int limit) {
        return this.commentCategoryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param commentCategory 实例对象
     * @return 实例对象
     */
    @Override
    public CommentCategory insert(CommentCategory commentCategory) {
        this.commentCategoryDao.insert(commentCategory);
        return commentCategory;
    }

    /**
     * 修改数据
     *
     * @param commentCategory 实例对象
     * @return 实例对象
     */
    @Override
    public CommentCategory update(CommentCategory commentCategory) {
        this.commentCategoryDao.update(commentCategory);
        return this.queryById(commentCategory.getCategoryId());
    }

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer categoryId) {
        return this.commentCategoryDao.deleteById(categoryId) > 0;
    }

    /**
     * 查詢所有
     * @return 对象列表
     */
    @Override
    public List<CommentCategory> selectAll(){
        return this.commentCategoryDao.selectAll();
    }
}