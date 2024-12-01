package com.mewhz.moments.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mewhz.moments.mapper.SettingMapper;
import com.mewhz.moments.model.entity.Setting;
import com.mewhz.moments.model.vo.SettingInsensitiveVO;
import com.mewhz.moments.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements SettingService {

    private final SettingMapper settingMapper;

    @Override
    public SettingInsensitiveVO getSettingInsensitive() {
        return BeanUtil.copyProperties(settingMapper.selectById(1), SettingInsensitiveVO.class);
    }

    @Override
    public Setting getSettingFull() {
        return settingMapper.selectById(1);
    }

    @Override
    public boolean updateSetting(Setting setting) {
        return settingMapper.updateById(setting.setId(1)) > 0;
    }
}
