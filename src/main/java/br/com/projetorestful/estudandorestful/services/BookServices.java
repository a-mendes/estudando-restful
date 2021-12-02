package br.com.projetorestful.estudandorestful.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetorestful.estudandorestful.converter.custom.BookConverter;
import br.com.projetorestful.estudandorestful.data.model.Book;
import br.com.projetorestful.estudandorestful.data.vo.BookVO;
import br.com.projetorestful.estudandorestful.exception.ResourceNotFoundException;
import br.com.projetorestful.estudandorestful.repository.BookRepository;

@Service
public class BookServices
{
	
	@Autowired
	BookRepository repository;
	
	@Autowired
	BookConverter converter;
	
	public BookVO create(BookVO book) {
		Book entity = converter.convertVOToEntity(book);
		BookVO vo = converter.convertEntityToVO(repository.save(entity));
		return vo;
	}
	
	public BookVO findById(int id)
	{			
		return converter.convertEntityToVO(repository.findById(id));
	}
	
	public List<BookVO> findAll()
	{
		List<BookVO> books = new ArrayList<BookVO>();
		
		for (Book book : repository.findAll()) 
			books.add(converter.convertEntityToVO(book));
		
		return books;
	}
	
	public BookVO update(BookVO book) {
		Book entity = repository.findById(book.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setNome(book.getNome());
		entity.setAutor(book.getAutor());
		entity.setDataPublicacao(book.getDataPublicacao());
		
		BookVO vo = converter.convertEntityToVO(repository.save(entity));
		
		return vo;
	}	
	
	public void delete(int id) 
	{
		Book entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
