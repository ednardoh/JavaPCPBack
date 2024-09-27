package com.chaodefabrica.pcp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CAD_GRIFES")
public class Grifes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    codigo;
    private String  nome;
}
