package br.com.fiap.domain.servico.view;

import br.com.fiap.domain.servico.model.Servico;

import javax.swing.*;
import java.time.LocalDateTime;

public class ServicoView {
    public static Servico formAbertura() {
        String nome = JOptionPane.showInputDialog("Nome do serviço: ");
        String descricao = JOptionPane.showInputDialog("Descrição do serviço: ");
        LocalDateTime dataAbertura = LocalDateTime.now();

        Servico servico = new Servico();

        servico.setNome(nome);
        servico.setDescricao(descricao);
        servico.setDataAberturaServico(dataAbertura);

        return servico;
    }
}
