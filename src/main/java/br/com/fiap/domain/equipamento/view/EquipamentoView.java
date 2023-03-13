package br.com.fiap.domain.equipamento.view;

import br.com.fiap.domain.equipamento.model.Equipamento;
import br.com.fiap.domain.equipamento.model.TipoEquipamento;

import javax.swing.*;

public abstract class EquipamentoView {


    public static Equipamento showForm(Equipamento e) {
        TipoEquipamento tipo = TipoEquipamentoView.select(e == null ? null : e.getTipo());
        String nome = JOptionPane.showInputDialog("Nome do " + tipo.getNome(), e == null ? "" : e.getNome());
        String numeroDeSerie = JOptionPane.showInputDialog("Número de série do(a) " + tipo.getNome(), e == null ? "" : e.getNumeroDeSerie());
        Equipamento equip = new Equipamento();

        equip.setTipo(tipo).setNome(nome).setNumeroDeSerie(numeroDeSerie).setId(e == null ? null : e.getId());

        return equip;
    }
}
