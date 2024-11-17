package com.mewhz.moments.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mewhz.moments.mapper.CommentMapper;
import com.mewhz.moments.mapper.MemoMapper;
import com.mewhz.moments.mapper.UserMapper;
import com.mewhz.moments.model.dto.MemoDTO;
import com.mewhz.moments.model.dto.MemoListDTO;
import com.mewhz.moments.model.entity.Comment;
import com.mewhz.moments.model.entity.Memo;
import com.mewhz.moments.model.vo.CommentVO;
import com.mewhz.moments.model.vo.MemoListVO;
import com.mewhz.moments.model.vo.MemoVO;
import com.mewhz.moments.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoServiceImpl extends ServiceImpl<MemoMapper, Memo> implements MemoService {

    private final MemoMapper memoMapper;

    private final UserMapper userMapper;

    private final CommentMapper commentMapper;

    @Override
    public boolean saveMemo(MemoDTO memoDTO) {

        Memo memo = new Memo();

        memo.setContent(memoDTO.getContent());
        memo.setImgs(memoDTO.getImgs().toString().replace("[", "").replace("]", ""));
        memo.setShowType(memoDTO.getShowType());

        return memoMapper.insert(memo) > 0;

    }

    @Override
    public MemoListVO listMemo(MemoListDTO memoListDTO) {

        Page<Memo> page = new Page<>(memoListDTO.getPage(), memoListDTO.getSize());

        page = memoMapper.selectPage(page,
                new LambdaQueryWrapper<Memo>()
                        .orderByDesc(Memo::getCreatedAt)
                        .eq(Memo::getShowType, 1)
                        .eq(Memo::getIsDelete, 0));

        MemoListVO result = new MemoListVO();

        result.setTotal(page.getTotal());
        result.setHasNext(page.hasNext());

        List<MemoVO> list = new ArrayList<>();

        page.getRecords().forEach(memo ->
                list.add(BeanUtil.copyProperties(memo, MemoVO.class)
                        .setUser(userMapper.selectById(memo.getUserId()))
                        .setComments(BeanUtil.copyToList(commentMapper
                                .selectList(new LambdaQueryWrapper<Comment>()
                                        .eq(Comment::getMemoId, memo.getId())
                                        .eq(Comment::getIsDelete, 0)),
                                CommentVO.class))));

        result.setList(list);

        return result;
    }

    @Override
    public boolean removeMemo(Integer id) {

        return memoMapper.updateById(new Memo().setId(id).setIsDelete(1)) > 0;

    }

    @Override
    public MemoVO getMemo(Integer id) {

        Memo memo = memoMapper.selectById(id);

        MemoVO memoVO = new MemoVO();

        BeanUtil.copyProperties(memo, memoVO);

        memoVO.setUser(userMapper.selectById(memo.getUserId()));

        memoVO.setComments(BeanUtil.copyToList(commentMapper
                .selectList(new LambdaQueryWrapper<Comment>()
                        .eq(Comment::getMemoId, id)
                        .eq(Comment::getIsDelete, 0)),
                CommentVO.class));

        return memoVO;
    }

    @Override
    public boolean likeMemo(Integer id) {

        Memo memo = memoMapper.selectById(id);

        if (memo != null && memo.getIsDelete() == 0) memo.setFavCount(memo.getFavCount() + 1);

        return memoMapper.updateById(memo) > 0;
    }


}
