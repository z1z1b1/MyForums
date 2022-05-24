package com.example.demo.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserMessageDao;
import com.example.demo.entity.UserMessage;
import com.example.demo.service.UserMessageService;

/**
 * (UserMessage)表服务实现类
 *
 * @author makejava
 * @since 2022-01-19 20:39:11
 */
@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService {
    @Resource
    private UserMessageDao userMessageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public UserMessage queryById(Long userId) {
        return this.userMessageDao.queryById(userId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserMessage> queryAllByLimit(int offset, int limit) {
        return this.userMessageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userMessage 实例对象
     * @return 实例对象
     */
    @Override
    public UserMessage insert(UserMessage userMessage) {
        this.userMessageDao.insert(userMessage);
        return userMessage;
    }

    /**
     * 修改数据
     *
     * @param userMessage 实例对象
     * @return 实例对象
     */
    @Override
    public UserMessage update(UserMessage userMessage) {
        this.userMessageDao.update(userMessage);
        return this.queryById(userMessage.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long userId) {
        return this.userMessageDao.deleteById(userId) > 0;
    }
}