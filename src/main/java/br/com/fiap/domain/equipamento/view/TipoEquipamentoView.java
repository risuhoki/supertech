package br.com.fiap.domain.equipamento.view;

import br.com.fiap.domain.equipamento.model.TipoEquipamento;

import javax.swing.*;

public class TipoEquipamentoView {
    public static TipoEquipamento showForm(TipoEquipamento te) {
        TipoEquipamento tipoEquip = new TipoEquipamento();

        tipoEquip.setNome(JOptionPane.showInputDialog("Digite o nome do equipamento: ", te == null ? "" : te.getNome()));
        tipoEquip.setId(te == null ? null : te.getId());

        return tipoEquip;
    }
}
