package com.example.demo.controller.user;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CommentMess;
import com.example.demo.service.CommentMessService;

/**
 * (CommentMess)表控制层
 *
 * @author makejava
 * @since 2022-01-25 13:50:21
 */
@RestController
@RequestMapping("commentMess")
public class CommentMessController {
    /**
     * 服务对象
     */
    @Resource
    private CommentMessService commentMessService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommentMess selectOne(Long id) {
        return this.commentMessService.queryById(id);
    }

    /**
     * 根据发表内容id查询评论消息
     *
     * @param commentMessId
     * @return
     */
    @GetMapping("selectComment")
    public Map<Integer, List<CommentMess>> selectComment(Long commentMessId) {
        return this.commentMessService.selectComment(commentMessId);
    }

    /**
     * 插入评论
     *
     * @return
     */
    @PostMapping("insertComment")
    public CommentMess insertComment(CommentMess commentMess) {
        return commentMessService.insert(commentMess);
    }
}