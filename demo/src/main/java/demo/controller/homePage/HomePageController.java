package demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import demo.VO.CommentVO;
import demo.entity.CommentCategory;
import demo.service.CommentCategoryService;
import demo.service.CommentMessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
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
     * 用户登录后默认显示各类别热度前十的数据
     */
    @GetMapping("selectHot")
    public List<CommentVO> selectHot() {
        List<CommentCategory> commentCategoryList = commentCategoryService.selectAll();
        List<CommentVO> commentVOList = commentMessService.queryLimt();
        //使用stream流把list1合并到list2集合中，根据ticketId属性
        List<CommentVO> list = commentVOList.stream().map(m -> {
            commentCategoryList.stream().filter(m2 -> Objects.equals(m.getCategoryId(), m2.getCategoryId())).forEach(m2 -> {
                m.setCategoryName(m2.getCategoryName());
            });
            return m;
        }).collect(Collectors.toList());
        return list;
    }

    /**
     * 置顶评论
     */
    @GetMapping("selectTop")
    public List<CommentVO> selectTop() {
        List<CommentVO> list = commentMessService.selectTop();
        return list;
    }

    /**
     * 查询所有
     */
    @GetMapping("selectAll")
    public PageInfo<CommentVO> selectAll() {
        PageHelper.startPage(0, 20);
        List<CommentVO> list = commentMessService.selectAll();
        PageInfo PageInfo = new PageInfo<CommentVO>(commentMessService.selectAll());

        return PageInfo;
    }

}
