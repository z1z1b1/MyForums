package demo.dao;

import java.util.List;

import demo.entity.UserByUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-19 20:39:08
 */
@Mapper
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserByUser queryById(Long userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserByUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * @param userName
     * @return
     */
    UserByUser selectByName(String userName);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param user 实例对象
     * @return 对象列表
     */
    List<UserByUser> queryAll(UserByUser user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(UserByUser user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(UserByUser user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Long userId);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    UserByUser login(UserByUser user);
}