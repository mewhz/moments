package com.mewhz.moments.controller;

import com.mewhz.moments.model.dto.MemoDTO;
import com.mewhz.moments.model.dto.MemoListDTO;
import com.mewhz.moments.model.vo.ResultVO;
import com.mewhz.moments.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/memo")
@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/save")
    public ResultVO<?> save(@RequestBody MemoDTO memoDTO) {
        return ResultVO.success(memoService.saveMemo(memoDTO));
    }

    @PostMapping("/list")
    public ResultVO<?> list(@RequestBody MemoListDTO memoListDTO) {
       return ResultVO.success(memoService.listMemo(memoListDTO));
    }

    @PostMapping("/remove")
    public ResultVO<?> remove(@RequestParam("id") Integer id) {
        return ResultVO.success(memoService.removeMemo(id));
    }

    @PostMapping("/get")
    public ResultVO<?> get(@RequestParam("id") Integer id) {
        return ResultVO.success(memoService.getMemo(id));
    }

    @PostMapping("/like")
    public ResultVO<?> like(@RequestParam("id") Integer id) {
        return ResultVO.success(memoService.likeMemo(id));
    }

}
