package com.chaodefabrica.pcp.model;

import com.chaodefabrica.pcp.dto.GradeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@Entity
@Table(name = "CAD_GRADE")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    codigo;
    private String  descricao;

    public Grade(GradeDTO gradeDTO) {
        BeanUtils.copyProperties(gradeDTO, this);
    }

    public Grade() {}

}
