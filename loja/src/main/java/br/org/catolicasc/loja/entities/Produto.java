package br.org.catolicasc.loja.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "produtos")
public class Produto implements EntityBase {
	@Id
	@GeneratedValue
	private Long id;
	private double preco;
	private String nome;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<ItemPedido> itemPedidos;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public List<ItemPedido> getItemPedidos() {
		return itemPedidos;
	}
	public void setItemPedidos(List<ItemPedido> itemPedidos) {
		this.itemPedidos = itemPedidos;
	}
	
}  
