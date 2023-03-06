package br.com.fiap.domain.cliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Telefone {
    @Column(
            name = "ddi_tel",
            length = 4
    )
    private String ddi;

    @Column(
            name = "ddd_tel",
            length = 7
    )
    private String ddd;

    @Column(
            name = "nr_tel",
            length = 25
    )
    private String telefone;
}
