package com.example.demo.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	private BookService service;
	public BookController(BookService service) {
		this.service= service;
	}
	@PostMapping("/add")
	public ResponseEntity<Books> addBooks(@RequestBody Books book){
		Books addBooks = service.AddBooks(book);
		return ResponseEntity.ok(addBooks);
	}
	@PostMapping("/update")
	public ResponseEntity<Books> updateBooks(@RequestBody Books book){
		Books updateBooks = service.updateBooks(book);
		return ResponseEntity.ok(updateBooks);
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBooks(@PathVariable Long id){
		service.deleteBook(id);
		return ResponseEntity.ok("Record Deleted..");
	}
	@GetMapping("/get")
	public ResponseEntity<List<Books>> getAllBooks(){
		List<Books> allBooks = service.getAllBooks();
		return ResponseEntity.ok(allBooks);
	}
}
