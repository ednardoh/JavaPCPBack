package com.chaodefabrica.pcp.dto;

import com.chaodefabrica.pcp.model.GradeLista;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class GradeListaDTO {
    private Long id;
    private GradeDTO gradedto;
    private TamanhoDTO tamanhodto;
    private String ordem;
    private String descricao;
    private String tamanho;

    public GradeListaDTO(GradeLista gradeLista) {
        BeanUtils.copyProperties(gradeLista, this);
        if(gradeLista != null && gradeLista.getGradeEntity() != null) {
            this.gradedto = new GradeDTO(gradeLista.getGradeEntity());
        }
        if(gradeLista != null && gradeLista.getTamanhoEntity() != null) {
            this.tamanhodto = new TamanhoDTO(gradeLista.getTamanhoEntity());
        }
    }
}
