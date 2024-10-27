package com.mewhz.moments.model.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@TableName("memo")
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Memo {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String content;
    private String imgs;
    private Integer favCount;
    private Integer commentCount;
    private Integer userId;
    private String createdAt;
    private String updatedAt;
    private String showType;
    private Integer isDelete;

}