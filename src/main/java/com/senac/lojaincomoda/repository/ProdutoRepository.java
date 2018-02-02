package com.senac.lojaincomoda.repository;

import org.springframework.data.repository.CrudRepository;

import com.senac.lojaincomoda.domain.Produto;

public interface ProdutoRepository  extends CrudRepository<Produto, Long>{
	
}