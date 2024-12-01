package com.mewhz.moments.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@TableName("setting")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Setting {

    @TableId( value = "id", type = IdType.AUTO)
    private Integer id;
    private String adminUserName;
    private String favicon;
    private String title;
    private String commentOrder;
    private String timeFormat;
    private Integer maxCommentLength;
    private Integer memoMaxHeight;
    private boolean enableS3;
    private boolean enableAutoLoadNextPage;
    private boolean enableComment;
    private boolean enableRegister;

}
