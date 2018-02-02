package com.senac.lojaincomoda.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Produto implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)	
	private String nome;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private Double preco;
	@Column(nullable = false)
	private Integer quantidade;
	@Column(nullable = false)
	private String tamanho;
	@Column(nullable = false)
	private String cor;
	@Column(nullable = false)
	private String imagem;
	
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name="produto_id"), inverseJoinColumns = @JoinColumn(name="categoria_id"))	
	private List<Categoria> categorias = new ArrayList<Categoria>();

	@ManyToMany
	@JoinTable(name = "Item", joinColumns = @JoinColumn(name="produto_id"), inverseJoinColumns = @JoinColumn(name="pedido_id"))	
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public Produto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
