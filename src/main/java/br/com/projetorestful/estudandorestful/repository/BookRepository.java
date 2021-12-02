package br.com.projetorestful.estudandorestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetorestful.estudandorestful.data.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{

}
