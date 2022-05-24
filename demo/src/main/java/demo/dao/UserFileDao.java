package demo.dao;

import java.util.List;

import demo.entity.UserFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * (UserFile)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-19 20:39:10
 */
@Mapper
public interface UserFileDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fileUuid 主键
     * @return 实例对象
     */
    UserFile queryById(String fileUuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserFile> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userFile 实例对象
     * @return 对象列表
     */
    List<UserFile> queryAll(UserFile userFile);

    /**
     * 新增数据
     *
     * @param userFile 实例对象
     * @return 影响行数
     */
    int insert(UserFile userFile);

    /**
     * 修改数据
     *
     * @param userFile 实例对象
     * @return 影响行数
     */
    int update(UserFile userFile);

    /**
     * 通过主键删除数据
     *
     * @param fileUuid 主键
     * @return 影响行数
     */
    int deleteById(String fileUuid);

    /**
     * 根据实体删除
     *
     * @param userFileList
     * @return
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