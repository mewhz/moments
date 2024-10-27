package com.mewhz.moments.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mewhz.moments.model.entity.Memo;
import com.mewhz.moments.model.vo.MemoVO;

public interface MemoService extends IService<Memo> {

    boolean saveMemo(MemoVO memoVO);

}
