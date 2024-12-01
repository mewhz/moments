package com.mewhz.moments.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mewhz.moments.model.entity.Setting;
import com.mewhz.moments.model.vo.SettingInsensitiveVO;

public interface SettingService extends IService<Setting> {

    SettingInsensitiveVO getSettingInsensitive();

    Setting getSettingFull();

    boolean updateSetting(Setting setting);



}
