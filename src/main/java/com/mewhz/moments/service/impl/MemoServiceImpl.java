package com.mewhz.moments.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mewhz.moments.mapper.MemoMapper;
import com.mewhz.moments.model.entity.Memo;
import com.mewhz.moments.model.vo.MemoVO;
import com.mewhz.moments.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemoServiceImpl extends ServiceImpl<MemoMapper, Memo> implements MemoService {

    private final MemoMapper memoMapper;

    @Override
    public boolean saveMemo(MemoVO memoVO) {

        Memo memo = new Memo();

        memo.setContent(memoVO.getContent());
        memo.setImgs(memoVO.getImgs().toString().replace("[", "").replace("]", ""));
        memo.setShowType(memoVO.getShowType());

        return memoMapper.insert(memo) > 0;

    }
}
