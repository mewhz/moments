package com.mewhz.moments.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mewhz.moments.model.dto.MemoDTO;
import com.mewhz.moments.model.dto.MemoListDTO;
import com.mewhz.moments.model.entity.Memo;
import com.mewhz.moments.model.vo.MemoListVO;
import com.mewhz.moments.model.vo.MemoVO;

public interface MemoService extends IService<Memo> {

    boolean saveMemo(MemoDTO memoDTO);

    MemoListVO listMemo(MemoListDTO memoListDTO);

    boolean removeMemo(Integer id);

    MemoVO getMemo(Integer id);

    boolean likeMemo(Integer id);

}
