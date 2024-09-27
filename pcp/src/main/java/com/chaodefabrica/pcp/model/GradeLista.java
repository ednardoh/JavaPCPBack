package com.chaodefabrica.pcp.model;

import com.chaodefabrica.pcp.dto.GradeListaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@Entity
@Table(name = "CAD_GRADELISTA")
public class GradeLista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CODIGO") //grade
    private Grade gradeEntity;

    @ManyToOne
    @JoinColumn(name = "ID_TAMANHO") //tamanho
    private Tamanho tamanhoEntity;

    private String ordem;
    private String descricao;
    private String tamanho;

    public GradeLista(GradeListaDTO gradeListaDTO) {
        BeanUtils.copyProperties(gradeListaDTO, this);
        if(gradeListaDTO != null && gradeListaDTO.getGradedto() != null) {
            this.gradeEntity = new Grade(gradeListaDTO.getGradedto());
        }
        if(gradeListaDTO != null && gradeListaDTO.getTamanhodto() != null) {
            this.tamanhoEntity = new Tamanho(gradeListaDTO.getTamanhodto());
        }
    }

    public GradeLista() {}

}
