package com.senac.notasaluno.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * As anotações do hibernate serão do javax.persistence
 * A anotação @Entity é utilizada para definir a classe como uma entidade(persistida) no banco
 * A anotação @Entity pode ter parametros passados como o nome da tabela, é necessário
 * adicionar () com o valor " name ", como no exemplo @Entity(name="tb_pessoa")
 * */
@MappedSuperclass
@Entity
public class Pessoa implements Serializable {
	
	/**
	 * A anotação @transient é utilizada para dizermos ao hibernate que aquele atributo
	 * não será persistido no banco de dados!!!
	 * */
@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false, unique = true)
	private String matricula;
	
	public Pessoa() {
		
		
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
