package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Books;

public interface BookService {
	
	public Books AddBooks(Books book);
	
	public Books deleteBook(Long id);
	
	public List<Books> getAllBooks();
	
	public Books updateBooks(Books book);
	
}
