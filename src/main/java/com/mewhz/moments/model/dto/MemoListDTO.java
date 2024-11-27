package com.mewhz.moments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MemoListDTO {

    private Long page;

    private Long size;

    private String contentContains;

    private Date start;

    private Date end;

    private Integer showType;

}
