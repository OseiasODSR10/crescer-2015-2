package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Servico;

@Repository
public class ServicoDao extends BaseDAO{

	public Servico findById(Long id) {
        return em.find(Servico.class, id);
    }
}
