package com.mewhz.moments.controller;

import com.mewhz.moments.model.vo.ResultVO;
import com.mewhz.moments.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/upload")
    public ResultVO<?> upload(@RequestParam("files") MultipartFile file) {
        return ResultVO.success(fileService.upload(file));
    }

}
