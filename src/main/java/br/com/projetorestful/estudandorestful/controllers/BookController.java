package br.com.projetorestful.estudandorestful.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetorestful.estudandorestful.data.vo.BookVO;
import br.com.projetorestful.estudandorestful.services.BookServices;

@RestController
@RequestMapping("/book")
public class BookController 
{
	@Autowired
	private BookServices service;
	
	@GetMapping()
	public List<BookVO> findAll()
	{
		return service.findAll();		
	}
	
	@GetMapping(value = "/get/{id}")
	public BookVO findById(@PathVariable("id") int id)
	{
		return service.findById(id);		
	}
	
	@PostMapping
	public BookVO create(@RequestBody BookVO book) {
		return service.create(book);
	}
	
	@PutMapping
	public BookVO update(@RequestBody BookVO book) {
		return service.update(book);
	}	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}	
}
