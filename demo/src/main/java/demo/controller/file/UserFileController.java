package demo.controller.file;

import demo.entity.UserFile;
import demo.service.UserFileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (UserFile)表控制层
 *
 * @author makejava
 * @since 2022-01-19 20:39:10
 */
@RestController
@RequestMapping("userFile")
public class UserFileController {
    /**
     * 服务对象
     */
    @Resource
    private UserFileService userFileService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserFile selectOne(String id) {
        return this.userFileService.queryById(id);
    }

}