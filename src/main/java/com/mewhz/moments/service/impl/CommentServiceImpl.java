package com.mewhz.moments.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mewhz.moments.mapper.CommentMapper;
import com.mewhz.moments.model.entity.Comment;
import com.mewhz.moments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    private final CommentMapper commentMapper;
    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }

    @Override
    public boolean removeComment(Integer id) {
        return commentMapper.updateById(new Comment().setId(id).setIsDelete(1)) > 0;
    }
}
