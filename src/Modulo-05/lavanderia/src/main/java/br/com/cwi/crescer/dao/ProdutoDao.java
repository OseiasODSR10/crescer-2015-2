package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDao extends BaseDAO{
	
	public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }
}
