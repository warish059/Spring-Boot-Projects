package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payload.Book;
import com.example.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
	private final BookService service;
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book){
		Book books = service.addBooks(book);
		return ResponseEntity.ok(books);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Book>> getBooks(){
		service.getAll();
		return ResponseEntity.ok();
	}
	@PutMapping("/updateall")
	public ResponseEntity<Book> updateAll(@RequestBody Book book){
		Book updateBook = service.updateBook(book);
		
		return ResponseEntity.ok(updateBook);
		
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<Book> updatePartialEntity(@PathVariable Long id,@RequestBody Book book){
		Book updatePartial = service.updatePartial(id, book);
		return ResponseEntity.ok(updatePartial);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteId(@PathVariable Long id){
		Book deleteBook = service.deleteBook(id);
		return ResponseEntity.ok("record deleted");
	}
	
}
