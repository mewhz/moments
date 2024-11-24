package com.mewhz.moments.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {

    private Integer id;
    private String content;
    private String username;
    private String website;
    private Integer memoId;
    private Integer author;
    private String replyTo;
    private String createdAt;
    private String updatedAt;

}
