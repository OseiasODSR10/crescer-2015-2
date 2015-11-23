package br.com.cwi.crescer.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
@SequenceGenerator(name = Item.SEQUENCE_NAME, 
					sequenceName = Item.SEQUENCE_NAME, 
					allocationSize = 1)
public class Item {
	
	public static final String SEQUENCE_NAME = "SEQ_Item";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDItem")
	private Long idItem;
	
	@Column(name = "IDPedido")
	@Basic(optional = false)
	private Long idPedido;
	
	@Column(name = "IDProduto")
	@Basic(optional = false)
	private Long idProduto;
	
	@Column(name = "Peso", precision = 12, scale = 2)
	@Basic(optional = false)
	private BigDecimal peso;
	
	@Column(name = "VALORUnitario", precision = 12, scale = 2)
	@Basic(optional = false)
	private BigDecimal valorUnitario;
	
	@Column(name = "VALORDesconto", precision = 12, scale = 2)
	@Basic(optional = false)
	private BigDecimal valorDesconto;
	
	@Column(name = "VALORTotal", precision = 12, scale = 2)
	@Basic(optional = false)
	private BigDecimal valorTotal;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Situacao")
	private SituacaoItem situacao;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public SituacaoItem getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}
	
	public static enum SituacaoItem{
		PENDENTE, PROCESSANDO, PROCESSADO
	}

}
