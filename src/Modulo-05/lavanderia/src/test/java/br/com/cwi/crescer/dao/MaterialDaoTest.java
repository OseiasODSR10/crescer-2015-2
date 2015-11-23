package br.com.cwi.crescer.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.domain.Material;

public class MaterialDaoTest extends BaseTest{

	@Autowired
    private MaterialDao materialDAO;

    @Test
    public void deveBuscarMaterialPorId() throws Exception {
        Material material = materialDAO.findById(1L);
        Assert.assertNotNull(material);
    }
}
