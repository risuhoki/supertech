package br.com.fiap.domain.documento.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_tp_documento"
    )
    @SequenceGenerator(
            name = "seq_tp_documento",
            sequenceName = "seq_tp_documento",
            allocationSize = 1
    )
    @Column(name = "id_tp_documento")
    private Long id;

    @Column(name = "nm_tp_documento")
    private String nome;
}
