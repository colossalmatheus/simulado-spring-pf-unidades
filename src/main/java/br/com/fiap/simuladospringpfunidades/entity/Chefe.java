package br.com.fiap.simuladospringpfunidades.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TB_CHEFE",
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_USUARIO_UNIDADE_FIM_CHEFE" , columnNames = {"USUARIO","UNIDADE","FIM"})
    }
)

public class Chefe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CHEFE")
    @SequenceGenerator(name = "SQ_CHEFE", sequenceName = "SQ_CHEFE", allocationSize = 1)
    @Column(name = "ID_CHEFE")
    private Long id;

    @Column(name = "SUBS_CHEFE")
    private Boolean substituto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "USUARIO",
            referencedColumnName = "ID_USUARIO",
            foreignKey = @ForeignKey(
                    name = "CHEFE_USUARIO_FK"
            )
    )
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "UNIDADE",
            referencedColumnName = "ID_UNIDADE",
            foreignKey = @ForeignKey(
                    name = "CHEFE_UNIDADE_FK"
            )
    )
    private Unidade unidade;


    @Column(name = "INICIO_CHEFE")
    private LocalDateTime inicio;

    @Column(name = "FIM_CHEFE")
    private LocalDateTime fim;

}
