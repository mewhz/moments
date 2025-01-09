package com.mewhz.moments.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mewhz.moments.mapper.CommentMapper;
import com.mewhz.moments.mapper.UserMapper;
import com.mewhz.moments.model.entity.Comment;
import com.mewhz.moments.service.CommentService;
import com.mewhz.moments.util.UserIdTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mewhz
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;

    @Override
    public boolean addComment(Comment comment) {
        log.info("UserIdTokenUtil.getUserId() = {}", UserIdTokenUtil.getUserId());
        if (UserIdTokenUtil.getUserId() != null) {
            int userId = UserIdTokenUtil.getUserId();
            comment.setAuthor(userId);
            comment.setUsername(userMapper.selectById(userId).getUsername());
            comment.setWebsite(null);
        }
        return commentMapper.insert(comment) > 0;
    }

    @Override
    public boolean removeComment(Integer id) {
        return commentMapper.updateById(new Comment().setId(id).setIsDelete(1)) > 0;
    }
}
