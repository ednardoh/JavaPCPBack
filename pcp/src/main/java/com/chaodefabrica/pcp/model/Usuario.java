package com.chaodefabrica.pcp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    codigo;
    private String  username;
    private String  senha;
    private Boolean bloquear;
    private Boolean online;
    private Boolean permissao_pedidovendaaprovar;
    private Boolean permissao_producaoaprovar;
    private Boolean permissao_producaofasemovimentar;
    private Boolean permissao_producaoatualizarestoque;
    private Boolean permissao_estoqueinventario;
    private Boolean permissao_notafiscalcancelar;
    private Boolean permissao_pedidovendaverprecos;
    private Boolean permissao_pedidovendaalterarpagamento;
    private Boolean permissao_produtoverprecos;
    private Boolean permissao_pedidovendadesconto;
}
