package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDao;
import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDto;
import br.com.cwi.crescer.dto.ClienteResumoDto;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {
	
	private ClienteDao clienteDao;
	private CidadeDao cidadeDao;
	
	@Autowired
	public ClienteService(ClienteDao clienteDao, CidadeDao cidadeDao){
		this.clienteDao = clienteDao;
		this.cidadeDao = cidadeDao;
	}

	public List<ClienteResumoDto> listarClientesAtivos(){
		List<Cliente> clientes = clienteDao.findBySituacao(SituacaoCliente.ATIVO);
		List<ClienteResumoDto> dtos = new ArrayList<ClienteResumoDto>();
		
		for(Cliente cliente : clientes){
			dtos.add(new ClienteResumoDto(cliente));
		}
		return dtos;
	}
	
	public Cliente buscarProId(Long id){
		return clienteDao.findById(id);
	}
	
	public void atualizar(ClienteDto dto) {

        Cliente entity = clienteDao.findById(dto.getId());

        ClienteMapper.merge(dto, entity);

        entity.setCidade(cidadeDao.findById(dto.getIdCidade()));

        clienteDao.save(entity);
    }
}
