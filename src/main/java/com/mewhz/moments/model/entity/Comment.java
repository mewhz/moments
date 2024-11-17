package com.mewhz.moments.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("comment")
public class Comment {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String content;
    private String username;
    private String website;
    private Integer memoId;
    private Integer authorId;
    private String createdAt;
    private String updatedAt;
    private Integer isDelete;

}
