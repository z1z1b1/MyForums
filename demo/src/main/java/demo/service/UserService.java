package demo.service;

import java.util.List;

import demo.VO.UserVO;
import org.json.JSONException;

import demo.entity.UserControl;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-01-19 20:39:08
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    UserControl queryById(Long userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserControl> queryAllByLimit(int offset, int limit);

    /**
     * @param userName
     * @return
     */
    UserControl selectByName(String userName);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    UserControl insert(UserControl user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    UserControl update(UserControl user);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Long userId);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    UserControl login(UserControl user);

    /**
     * 修改密码
     * @param loginUser
     * @return
     */
    String editPassword(UserVO loginUser);

    /**
     *
     * 登录
     * @param loginUser
     * @return
     * @throws JSONException
     */
    String userLogin(UserControl loginUser) throws JSONException;
}