package br.com.fiap.simuladospringpfunidades.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TB_UNIDADE")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_UNIDADE")
    @SequenceGenerator(name = "SQ_UNIDADE", sequenceName = "SQ_UNIDADE", allocationSize = 1)
    @Column(name = "ID_UNIDADE")
    private Long id;


    private String nome;

    private String sigla;

    private String descricao;

    private Unidade macro;

}
