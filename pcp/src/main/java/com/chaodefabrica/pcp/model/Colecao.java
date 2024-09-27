package com.chaodefabrica.pcp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CAD_COLECAO")
public class Colecao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    @Column(name="PERIODO_INI")
    private Date periodoIni;
    @Column(name="PERIODO_FIM")
    private Date periodoFim;
    @Column(name="PECAS_META")
    private Integer pecasMeta;
    @Column(name="QTDE_MODELOS")
    private Integer qtdeModelos;
    @Column(name="VALOR_META")
    private double valorMeta;
    @Column(name="STATUS")
    private String status;
}
