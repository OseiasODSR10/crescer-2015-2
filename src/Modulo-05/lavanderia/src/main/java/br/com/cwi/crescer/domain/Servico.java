package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Servico")
@SequenceGenerator(name = Servico.SEQUENC_NAME,
					sequenceName = Servico.SEQUENC_NAME,
					allocationSize = 1)
public class Servico {
	
	public static final String SEQUENC_NAME = "SEQ_Servico";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENC_NAME)
	@Column(name = "IDServico")
	private Long idServico;
	
	@Column(name = "Descricao", length = 30)
	@Basic(optional = false)
	private String descricao;

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
