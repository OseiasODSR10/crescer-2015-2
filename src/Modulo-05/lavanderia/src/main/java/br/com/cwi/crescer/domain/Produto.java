package br.com.cwi.crescer.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE_NAME, 
					sequenceName = Produto.SEQUENCE_NAME,
					allocationSize = 1)			
public class Produto {
	
	public static final String SEQUENCE_NAME = "SEQ_Produto";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDProduto")
	private Long idProduto;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "IDServico")
    @Basic(optional = false)
    private Servico servico;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDMaterial")
    @Basic(optional = false)
    private Material material;
	
	@Column(name = "Valor")
	@Basic(optional = false)
	private BigDecimal valor;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Servico getIdServico() {
		return servico;
	}

	public void setIdServico(Servico servico) {
		this.servico = servico;
	}

	public Material getIdMaterial() {
		return material;
	}

	public void setIdMaterial(Material material) {
		this.material = material;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
