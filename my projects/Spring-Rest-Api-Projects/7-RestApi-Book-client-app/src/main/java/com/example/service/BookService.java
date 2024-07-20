package com.example.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.payload.Book;

@Service
public class BookService {
	
	public Book addBook(Book book) {
		String url ="http://localhost:8080/api/book/add";
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Book> postForEntity = rt.postForEntity(url, book, Book.class);
		
		return postForEntity.getBody();
	}
	
	public List<Book> getBook(Book book) {
		
		String url = "http://localhost:8080/api/book/get";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<List> response = rt.getForEntity(url, List.class);
		return response.getBody();
	}
	
	 public Book[] getAll() {
	        String url = "http://localhost:8080/api/book/get";
	        RestTemplate rt = new RestTemplate();
	        ResponseEntity<Book[]> response = rt.getForEntity(url, Book[].class);
	        return response.getBody();
	    }
	
	
}
