package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDao;
import br.com.cwi.crescer.domain.Cidade;

@Service
public class CidadeService {

	private CidadeDao cidadeDao;
	
	@Autowired
	public CidadeService(CidadeDao cidadeDao){
		this.cidadeDao = cidadeDao;
	}
	
	public List<Cidade> listar(){
		return cidadeDao.listAll();
	}
}
