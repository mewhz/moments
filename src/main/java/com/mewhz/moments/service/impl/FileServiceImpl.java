package com.mewhz.moments.service.impl;

import cn.hutool.core.io.FileUtil;
import com.mewhz.moments.service.FileService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileServiceImpl implements FileService {

    private final String filePath = System.getProperty("user.dir") + "/upload/";

    @SneakyThrows
    @Override
    public String upload(MultipartFile file) {

        if (!FileUtil.isDirectory(filePath)) FileUtil.mkdir(filePath);

        String fileName = file.getOriginalFilename();

        File destinationFile = new File(filePath + fileName);
        file.transferTo(destinationFile); // 将文件存储到指定路径

        return "/upload/" + fileName;

    }
}
