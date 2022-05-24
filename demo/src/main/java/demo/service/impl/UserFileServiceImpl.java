package demo.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import demo.dao.UserFileDao;
import demo.entity.UserFile;
import demo.service.UserFileService;

/**
 * (UserFile)表服务实现类
 *
 * @author makejava
 * @since 2022-01-19 20:39:10
 */
@Service("userFileService")
public class UserFileServiceImpl implements UserFileService {
    @Resource
    private UserFileDao userFileDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fileUuid 主键
     * @return 实例对象
     */
    @Override
    public UserFile queryById(String fileUuid) {
        return this.userFileDao.queryById(fileUuid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserFile> queryAllByLimit(int offset, int limit) {
        return this.userFileDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userFile 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(UserFile userFile) {
        return userFileDao.insert(userFile);
    }

    /**
     * 修改数据
     *
     * @param userFile 实例对象
     * @return 实例对象
     */
    @Override
    public UserFile update(UserFile userFile) {
        this.userFileDao.update(userFile);
        return this.queryById(userFile.getFileUuid());
    }

    /**
     * 通过主键删除数据
     *
     * @param fileUuid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String fileUuid) {
        return this.userFileDao.deleteById(fileUuid) > 0;
    }

    /**
     * 根据实体就删除数据
     *
     * @return 是否成功
     */
    @Override
    public int deleteByUser(List<UserFile> userFileList) {
        return userFileDao.deleteByUser(userFileList);
    }

    /**
     * 文件查看
     *
     * @param userId
     * @return
     */
    public List<UserFile> fileList(String userId) {
        return userFileDao.fileList(userId);
    }
}