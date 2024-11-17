package com.mewhz.moments.controller;

import com.mewhz.moments.model.entity.Comment;
import com.mewhz.moments.model.vo.ResultVO;
import com.mewhz.moments.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/add")
    public ResultVO<?> addComment(@RequestBody Comment comment) {
        return ResultVO.success(commentService.addComment(comment));
    }

    @PostMapping("/remove")
    public ResultVO<?> removeComment(@RequestParam("id") Integer id) {
        return ResultVO.success(commentService.removeComment(id));
    }
}
