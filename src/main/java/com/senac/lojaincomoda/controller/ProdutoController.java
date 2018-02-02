 package com.senac.lojaincomoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.senac.lojaincomoda.domain.Produto;
import com.senac.lojaincomoda.repository.ProdutoRepository;

@Controller
@RequestMapping(path="/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;

	@GetMapping()
	public @ResponseBody Iterable<Produto> all() {
		return repository.findAll();
	}
	
	@PostMapping()
	public @ResponseBody String add(@RequestBody Produto produto) {
		repository.save(produto);
		return "Saved";
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody String remove(@PathVariable long id) {
		repository.delete(id);
		return "Removed";
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Produto> findById(@PathVariable long id) {
		Produto produto = repository.findOne(id);
		return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Produto> update(@RequestBody Produto produto) {
		repository.save(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.ACCEPTED);
	}
}
