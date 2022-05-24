package com.example.demo.service;

import java.util.List;

import org.json.JSONException;

import com.example.demo.userVO.UserVO;
import com.example.demo.entity.UserByUser;

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
    UserByUser queryById(Long userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserByUser> queryAllByLimit(int offset, int limit);

    /**
     * @param userName
     * @return
     */
    UserByUser selectByName(String userName);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    UserByUser insert(UserByUser user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    UserByUser update(UserByUser user);

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
    UserByUser login(UserByUser user);

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
    String userLogin(UserByUser loginUser) throws JSONException;
}