package com.chaodefabrica.pcp.dto;

import com.chaodefabrica.pcp.model.Grade;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class GradeDTO {

    private Long    codigo;
    private String  descricao;

    public GradeDTO(Grade grade) {
        BeanUtils.copyProperties(grade, this);
    }

    public GradeDTO() {}

}
