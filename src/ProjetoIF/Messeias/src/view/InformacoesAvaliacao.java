package view;

import entidades.Avaliacao;

public class InformacoesAvaliacao {
	
	private Avaliacao avaliacao;
	
	public InformacoesAvaliacao(Avaliacao avaliacao){
		this.avaliacao = avaliacao;
		System.out.println(avaliacao.getIdAvaliacao());
		System.out.println(avaliacao.getDisciplina());
	}

}
