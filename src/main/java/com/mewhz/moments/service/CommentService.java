package com.mewhz.moments.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mewhz.moments.model.entity.Comment;

/**
 * 用于处理评论（Comment）相关的操作
 *
 * @author mewhz
 */
public interface CommentService extends IService<Comment> {

    /**
     * 添加一个评论到服务中
     *
     * @param comment
     * @return 如果评论成功添加，返回true；否则返回false
     */
    boolean addComment(Comment comment);

    /**
     * 根据评论的ID删除评论
     *
     * @param id 要删除的评论的唯一标识符
     * @return 如果评论成功删除，返回true；否则返回false
     */
    boolean removeComment(Integer id);

}

