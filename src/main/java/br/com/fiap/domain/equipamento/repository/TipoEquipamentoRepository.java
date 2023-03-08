package br.com.fiap.domain.equipamento.repository;

import br.com.fiap.abstracao.Repository;
import br.com.fiap.domain.equipamento.model.TipoEquipamento;

public class TipoEquipamentoRepository extends Repository {
    public static TipoEquipamento save(TipoEquipamento te) {
        manager.getTransaction().begin();
        manager.persist(te);
        manager.getTransaction().commit();

        return te;
    }

    public static TipoEquipamento findById() {

    }
}
