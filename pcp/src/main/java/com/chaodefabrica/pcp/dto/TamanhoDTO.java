package com.chaodefabrica.pcp.dto;

import com.chaodefabrica.pcp.model.Tamanho;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class TamanhoDTO {

    private Long    codigo;
    private String  tamanho;
    private String  descricao;

    public TamanhoDTO(Tamanho tamanhoEntity) {
        BeanUtils.copyProperties(tamanhoEntity, this);
    }

}
