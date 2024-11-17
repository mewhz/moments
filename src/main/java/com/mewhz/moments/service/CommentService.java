package com.mewhz.moments.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mewhz.moments.model.entity.Comment;

public interface CommentService extends IService<Comment> {

    boolean addComment(Comment comment);

    boolean removeComment(Integer id);

}
