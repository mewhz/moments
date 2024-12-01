package com.mewhz.moments.controller;

import com.mewhz.moments.model.entity.Setting;
import com.mewhz.moments.model.vo.ResultVO;
import com.mewhz.moments.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sysConfig")
@RestController
@RequiredArgsConstructor
public class SettingController {

    private final SettingService settingService;

    @PostMapping("/get")
    public ResultVO<?> getSetting() {
        return ResultVO.success(settingService.getSettingInsensitive());
    }

    @PostMapping("/getFull")
    public ResultVO<?> getSettingFull() {
        return ResultVO.success(settingService.getSettingFull());
    }

    @PostMapping("/save")
    public ResultVO<?> saveSetting(@RequestBody Setting setting) {
        return ResultVO.success(settingService.updateSetting(setting));
    }

}
