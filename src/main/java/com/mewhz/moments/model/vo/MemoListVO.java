package com.mewhz.moments.model.vo;

import com.mewhz.moments.model.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemoListVO {

    private List<MemoVO> list;

    private boolean hasNext;

    private Long total;

}
