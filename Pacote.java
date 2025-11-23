package com.agencia.viagens.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="pacotes")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Pacote {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private Double preco;

    @ManyToOne
    @JoinColumn(name="destino_id")
    private Destino destino;
}
