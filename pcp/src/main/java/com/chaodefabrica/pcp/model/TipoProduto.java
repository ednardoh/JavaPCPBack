package com.chaodefabrica.pcp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CAD_PRODUTOS_TIPO")
public class TipoProduto {
    @Id
    private String  codigo;
    private String  nome;
}
