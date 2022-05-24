package demo.controller;

import demo.VO.CommentVO;
import demo.entity.CommentCategory;
import demo.service.CommentCategoryService;
import demo.service.CommentMessService;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.Ticket;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 消息类别表(CommentCategory)表控制层
 *
 * @author makejava
 * @since 2022-05-24 21:53:42
 */
@RestController
@RequestMapping("commentCategory")
public class HomePageController {
    /**
     * 服务对象
     */
    @Resource
    private CommentCategoryService commentCategoryService;
    @Resource
    CommentMessService commentMessService;
    /**
     * 用户登录后查询各类别前十条数据
     */
    @GetMapping("selectOne")
    public List<CommentVO> selectOne() {
        List<CommentCategory> commentCategoryList = commentCategoryService.selectAll();
        List<CommentVO> commentVOList= commentMessService.queryLimt();
        //使用stream流把list1合并到list2集合中，根据ticketId属性
        List<CommentVO> list = commentVOList.stream().map(m -> {
            commentCategoryList.stream().filter(m2-> Objects.equals(m.getCategoryId(),m2.getCategoryId())).forEach(m2-> {
                m.setCategoryName(m2.getCategoryName());
            });
            return m;
        }).collect(Collectors.toList());
        return list;
    }
}