package com.chaodefabrica.pcp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CAD_SUBGRUPO")
public class SubGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    codigo;
    private String  descricao;
}
