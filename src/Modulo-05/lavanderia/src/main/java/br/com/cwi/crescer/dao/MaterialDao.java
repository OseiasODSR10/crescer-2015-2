package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;

@Repository
public class MaterialDao extends BaseDAO{

	public Material findById(Long id) {
        return em.find(Material.class, id);
    }
}
