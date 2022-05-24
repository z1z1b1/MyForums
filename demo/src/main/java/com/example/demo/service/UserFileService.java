package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserFile;

/**
 * (UserFile)表服务接口
 *
 * @author makejava
 * @since 2022-01-19 20:39:10
 */
public interface UserFileService {

    /**
     * 通过ID查询单条数据
     *
     * @param fileUuid 主键
     * @return 实例对象
     */
    UserFile queryById(String fileUuid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserFile> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userFile 实例对象
     * @return 实例对象
     */
    int insert(UserFile userFile);

    /**
     * 修改数据
     *
     * @param userFile 实例对象
     * @return 实例对象
     */
    UserFile update(UserFile userFile);

    /**
     * 通过主键删除数据
     *
     * @param fileUuid 主键
     * @return 是否成功
     */
    boolean deleteById(String fileUuid);

    /**
     * 根据实体就删除数据
     *
     * @return 是否成功
     */
    int deleteByUser(List<UserFile> userFileList);

    /**
     * 文件查看
     *
     * @param userId
     * @return
     */
    List<UserFile> fileList(String userId);
}