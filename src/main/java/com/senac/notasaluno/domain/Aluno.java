package com.senac.notasaluno.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Aluno extends Pessoa{
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String situacao;
	
	public Aluno() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
