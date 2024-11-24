package com.mewhz.moments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemoDTO {

    private Integer id;
    private String content;
    private List<String> imgs;
    private Integer pinned;
    private Integer showType;

}
