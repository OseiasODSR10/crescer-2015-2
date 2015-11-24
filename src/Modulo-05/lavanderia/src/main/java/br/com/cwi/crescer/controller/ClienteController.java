package br.com.cwi.crescer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDto;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	private ClienteService clienteService;
	private CidadeService cidadeService;
	
	@Autowired
	public ClienteController(ClienteService clienteService, CidadeService cidadeService){
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("clientes/lista", "clientes", clienteService.listarClientesAtivos());
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewExibe(@PathVariable("id") Long id){
		return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarProId(id));
	}
	
	@RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView viewEdita(@PathVariable("id") Long id){
		return new ModelAndView("cliente/edita", "cliente", clienteService.buscarProId(id));
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.POST)
	public ModelAndView editar(ClienteDto clienteDto){
		clienteService.atualizar(clienteDto);
		return new ModelAndView("redirect:/clientes");
	}
	
	

	@ModelAttribute("cidades")
	public List<Cidade> comboCidades(){
		return cidadeService.listar();
	}
}
