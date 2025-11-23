package com.agencia.viagens.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="destinos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Destino {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String pais;
    private String descricao;
}
