package br.com.projetorestful.estudandorestful.converter.custom;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.projetorestful.estudandorestful.data.model.Book;
import br.com.projetorestful.estudandorestful.data.vo.BookVO;

@Service
public class BookConverter 
{
	public BookVO convertEntityToVO(Book book) {
	
		BookVO vo = new BookVO();
		
		vo.setId(book.getId());
		vo.setNome(book.getNome());
		vo.setAutor(book.getAutor());
		vo.setDataPublicacao(book.getDataPublicacao());
		
		return vo;
	}	
	
	public BookVO convertEntityToVO(Optional<Book> opBook) {
		
		BookVO vo = new BookVO();
		
		vo.setId(opBook.get().getId());
		vo.setNome(opBook.get().getNome());
		vo.setAutor(opBook.get().getAutor());
		vo.setDataPublicacao(opBook.get().getDataPublicacao());
		
		return vo;
	}
	
	public Book convertVOToEntity(BookVO book) {
		Book entity = new Book();
		
		entity.setId(book.getId());
		entity.setNome(book.getNome());
		entity.setAutor(book.getAutor());
		entity.setDataPublicacao(book.getDataPublicacao());
		
		return entity;
	}
}
