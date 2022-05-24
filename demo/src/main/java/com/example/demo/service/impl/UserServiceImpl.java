package com.example.demo.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.example.demo.controller.userVO.UserVO;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.UserByUser;
import com.example.demo.service.UserService;
import com.example.demo.util.TokenUtil;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-01-19 20:39:09
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public UserByUser queryById(Long userId) {
        return this.userDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserByUser> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * @param userName
     * @return
     */
    @Override
    public UserByUser selectByName(String userName) {
        return this.userDao.selectByName(userName);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public UserByUser insert(UserByUser user) {
        userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public UserByUser update(UserByUser user) {
        this.userDao.update(user);
        return this.queryById(user.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.userDao.deleteById(userId) > 0;
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public UserByUser login(UserByUser user) {
        return this.userDao.login(user);
    }

    /**
     * 修改密码
     * @param loginUser
     * @return
     */
    @Override
    public String editPassword(UserVO loginUser){
        UserByUser user = new UserByUser();
        user.setUserId(loginUser.getUserId());
        user.setUserPassword(loginUser.getUserPassword());
        if(this.login(user)==null){
            return "原密码错误";
        }else {
            user.setUserPassword(loginUser.getNewUserPassword());
            this.update(user);
            return "修改成功";
        }
    }

    /**
     * 登录
     * @param loginUser
     * @return
     * @throws JSONException
     */
    @Override
    public String userLogin(UserByUser loginUser) throws JSONException{

        //数据库进行检查
        UserByUser user = this.userDao.login(loginUser);

        JSONObject result = new JSONObject();
        //若正确返回200，若错误返回400
        if (user == null) {
            result.put("state", 400);
        } else {
            String token = TokenUtil.sign(user);
            System.out.println(token);
            result.put("state", 200);
            result.put("token", token);
        }
        return result.toString();
    }
}