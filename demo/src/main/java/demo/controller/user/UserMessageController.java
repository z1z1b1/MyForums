package demo.controller.user;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.UserMessage;
import demo.service.UserMessageService;

/**
 * (UserMessage)表控制层
 *
 * @author makejava
 * @since 2022-01-19 20:39:11
 */
@RestController
@RequestMapping("userMessage")
public class UserMessageController {
    /**
     * 服务对象
     */
    @Resource
    private UserMessageService userMessageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserMessage selectOne(Long id) {
        return this.userMessageService.queryById(id);
    }

}