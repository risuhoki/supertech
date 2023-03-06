package br.com.fiap.domain.cliente.model;

import jakarta.persistence.*;
import org.checkerframework.common.aliasing.qual.Unique;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(
        name = "tb_cliente",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_email_cliente",
                        columnNames = "email_cliente"
                ),
                @UniqueConstraint(
                        name = "id_cliente",
                        columnNames = "id_cliente"
                )
        },
        indexes = {
                @Index(
                        name = "idx_nm_cliente",
                        columnList = "nm_cliente"
                ),
                @Index(
                        name = "idx_email_cliente",
                        columnList = "email_cliente"
                )
        }
)
public class Cliente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_cliente"
    )
    @SequenceGenerator(
            name = "seq_cliente",
            sequenceName = "seq_cliente",
            allocationSize = 1
    )
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nm_cliente")
    private String nome;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "id_tp_cliente",
            referencedColumnName = "id_tp_cliente",
            foreignKey = @ForeignKey(name = "fk_tp_cliente", value = ConstraintMode.CONSTRAINT)
    )
    private TipoCliente tipo;

    @Column(name = "email_cliente")
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nasc_cliente")
    private LocalDate dtNascimento;

    @Embedded
    private Telefone telefone;
}
