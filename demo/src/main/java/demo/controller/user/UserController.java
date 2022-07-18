package demo.controller.user;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.VO.UserVO;
import demo.entity.UserControl;
import demo.service.UserService;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-01-19 20:39:09
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserControl selectOne(Long id) {
        return this.userService.queryById(id);
    }

    /**
     * 更改密码
     * @param loginUser
     * @return
     */
    @PostMapping("editPassword")
    public String editPassword(UserVO loginUser){
       return this.userService.editPassword(loginUser);
    }

}