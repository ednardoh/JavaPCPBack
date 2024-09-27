package com.chaodefabrica.pcp.model;

import com.chaodefabrica.pcp.dto.TamanhoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CAD_TAMANHOS")
public class Tamanho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    codigo;
    private String  tamanho;
    private String  descricao;

    public Tamanho(TamanhoDTO tamanhodto) {
        BeanUtils.copyProperties(tamanhodto, this);
    }
}
