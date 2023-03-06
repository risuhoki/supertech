package br.com.fiap.domain.documento.model;

import br.com.fiap.domain.cliente.model.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_documento")
public class Documento {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_documento"
    )
    @SequenceGenerator(
            name = "seq_documento",
            sequenceName = "seq_documento"
    )
    @Column(name = "id_documento")
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "id_cliente",
            referencedColumnName = "id_cliente",
            foreignKey = @ForeignKey(
                    name = "fk_doc_cliente",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Cliente cliente;

    @Column(name = "nr_documento")
    private String numero;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH
    )
    @JoinColumn(
            name = "id_tp_documento",
            referencedColumnName = "id_tp_documento",
            foreignKey = @ForeignKey(
                    name = "fk_tp_documento",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private TipoDocumento tipo;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_emissao_documento")
    private LocalDate emissao;
}
