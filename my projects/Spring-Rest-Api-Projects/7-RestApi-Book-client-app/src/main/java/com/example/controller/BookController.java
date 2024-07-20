package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payload.Book;
import com.example.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	private BookService service;
	
	public BookController(BookService service) {
		this.service=service;
	}
	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		Book book2 = service.addBook(book);
		return ResponseEntity.ok(book2);
	}
	
	@GetMapping("/getBook")
	public ResponseEntity<List<Book>> getBooks(Book book){
		List<Book> book2 = service.getBook(book);
		System.out.println(book2);
		return ResponseEntity.ok(book2);
	}
	 @GetMapping("/getAll")
	    public void getAll() {
	        Book[] books = service.getAll(); // Fetch all books
	        if (books != null) {
	            for (Book book : books) {
	                System.out.println(book); // Print each book
	            }
	        } else {
	            System.out.println("No books found.");
	        }
	    

}
}
