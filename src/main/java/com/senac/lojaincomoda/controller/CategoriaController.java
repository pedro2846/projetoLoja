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

import com.senac.lojaincomoda.domain.Categoria;
import com.senac.lojaincomoda.repository.CategoriaRepository;

@Controller
@RequestMapping(path="/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping()
	public @ResponseBody Iterable<Categoria> all() {
		return repository.findAll();
	}
	
	@PostMapping()
	public @ResponseBody String add(@RequestBody Categoria categoria) {
		repository.save(categoria);
		return "Saved";
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody String remove(@PathVariable long id) {
		repository.delete(id);
		return "Removed";
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable long id) {
		Categoria categoria = repository.findOne(id);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
		repository.save(categoria);
		return new ResponseEntity<Categoria>(categoria, HttpStatus.ACCEPTED);
	}
}
