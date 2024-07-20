package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Books;
import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private BookRepository repository;
	public BookServiceImpl(BookRepository repository) {
		this.repository=repository;
	}

	@Override
	public Books AddBooks(Books book) {
		Books save = repository.save(book);
		return save;
		
	}

	@Override
	public Books deleteBook(Long id) {
		Optional<Books> byId = repository.findById(id);
		if(byId.isPresent()) {
			Books books = byId.get();
			repository.delete(books);
			
		}
		return null;
	
	}

	@Override
	public List<Books> getAllBooks() {
		List<Books> all = repository.findAll();
		return all;
		
	}

	@Override
	public Books updateBooks(Books book){ {
		Long id = book.getId();
		if(id!=null) {
			repository.save(book);
			return book;
		}
		else {
			return book;
		}
		
	}
		
		
	}

}
