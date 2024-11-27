package com.mewhz.moments.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserVO {

    private Integer id;
    private String username;
    private String nickname;
    private String avatarUrl;
    private String coverUrl;
    private String slogan;

}
