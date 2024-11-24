package com.mewhz.moments.model.vo;

import com.mewhz.moments.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemoVO {

    private Integer id;
    private String content;
    private String imgs;
    private Integer favCount;
    private Integer commentCount;
    private Integer userId;
    private String createdAt;
    private String updatedAt;
    private Integer pinned;
    private Integer showType;

    private User user;

    private List<CommentVO> comments;

}
