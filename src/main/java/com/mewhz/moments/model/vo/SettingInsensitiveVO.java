package com.mewhz.moments.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SettingInsensitiveVO {
    
    private String adminUserName;
    private String favIcon;
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
