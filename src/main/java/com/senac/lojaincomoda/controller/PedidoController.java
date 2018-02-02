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

import com.senac.lojaincomoda.domain.Pedido;
import com.senac.lojaincomoda.domain.Produto;
import com.senac.lojaincomoda.repository.PedidoRepository;

@Controller
@RequestMapping(path="/pedidos")

public class PedidoController {

	@Autowired
	private PedidoRepository repository;
	
	@GetMapping()
	public @ResponseBody Iterable<Pedido> all(){
		return repository.findAll();
	}
	
	@PostMapping()
	public @ResponseBody String add(@RequestBody Pedido pedido) {
		repository.save(pedido);
		return "Saved";
	}
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody String remove(@PathVariable long id) {
		repository.delete(id);
		return "Removed";
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable long id) {
		Pedido pedido = repository.findOne(id);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<Pedido> update(@RequestBody Pedido pedido) {
		repository.save(pedido);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.ACCEPTED);
	}
	}
