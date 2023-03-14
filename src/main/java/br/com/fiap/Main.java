package br.com.fiap;

import br.com.fiap.domain.equipamento.model.Equipamento;
import br.com.fiap.domain.equipamento.model.TipoEquipamento;
import br.com.fiap.domain.equipamento.repository.EquipamentoRepository;
import br.com.fiap.domain.equipamento.repository.TipoEquipamentoRepository;
import br.com.fiap.domain.equipamento.view.EquipamentoView;
import br.com.fiap.domain.equipamento.view.TipoEquipamentoView;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opc = montaMenu();

        while (opc != 0) {
            switch (opc) {
                case 1 -> cadastrarTipoDeEquipamento();
                case 2 -> cadastrarEquipamento();

                default -> {
                    System.out.println("Opção inválida!");
                    System.exit(0);
                }
            }

            opc = montaMenu();
        }

        EquipamentoRepository.manager.close();
        EquipamentoRepository.factory.close();
    }

    private static int montaMenu() {
        Scanner leitor = new Scanner(System.in);
        String msg = """
                Bem-vindo(a) ao SUPERTECH
                
                Selecione:
                
                1 - Cadastramento de Tipo de Equipamento
                2 - Cadastramento de Equipamento
                3 - Abertura de serviço
                
                0 - Sair
                """;

        System.out.println(msg);

        return leitor.nextInt();
    }

    private static void cadastrarTipoDeEquipamento() {
        TipoEquipamento tipo = TipoEquipamentoView.form(null);

        tipo = TipoEquipamentoRepository.save(tipo);

        if (tipo != null) {
            JOptionPane.showMessageDialog(null, "Tipo de equipamento salvo com sucesso");
            System.out.println(tipo);
        }
    }

    private static void cadastrarEquipamento() {
        Equipamento equip = EquipamentoView.form(null);

        EquipamentoRepository.save(equip);
        JOptionPane.showMessageDialog(null, "Equipamento salvo com sucesso");
        System.out.println(equip);
    }
}