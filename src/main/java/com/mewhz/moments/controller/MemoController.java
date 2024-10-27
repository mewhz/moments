package com.mewhz.moments.controller;

import com.mewhz.moments.model.entity.Memo;
import com.mewhz.moments.model.vo.MemoVO;
import com.mewhz.moments.model.vo.ResultVO;
import com.mewhz.moments.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/memo")
@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/save")
    public ResultVO<?> save(@RequestBody MemoVO memoVO) {
        return ResultVO.success(memoService.saveMemo(memoVO));
    }

}
