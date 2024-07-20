package com.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;


import com.example.payload.Book;

import reactor.core.Disposable;



@Service
//@RequiredArgsConstructor
public class BookService {
	
	private  WebClient webClient;
	public BookService(WebClient.Builder web) {
		this.webClient=web.baseUrl("http://localhost:8080/api/book").build();
	}
//	private final WebClient.Builder webBuilder;
//	public Book addBook(Book book) {
//        String url = "http://localhost:8080/api/book/add";
//        WebClient webClient = webBuilder.build();
//
//        return webClient.post()
//                        .uri(url)
//                        .bodyValue(book)
//                        .retrieve()
//                        .bodyToMono(Book.class)
//                        .block(); // Blocks until the response is available
//    }
	public Book addBooks(Book book) {
//		String url = "http://localhost:8080/api/book/update";
//        WebClient webClient = WebClient.create();
         Book block = webClient.post()
        		.uri("/add")
        		.bodyValue(book)
        		.retrieve().bodyToMono(Book.class).block();
        		
//         System.out.println(block.toCharArray());
        return block;
		// while returning the 
	}
	public List<Book> getAll() {
		
//		String url = "http://localhost:8080/api/book/get";
//		WebClient web = WebClient.create();
		webClient.get().uri("/get").retrieve().bodyToFlux(Book.class).
				collectList().subscribe();
		System.out.println("Request sent");
		return null;
		
		
	}
	public Book updateBook(Book book) {
//		String url = "http://localhost:8080/api/book/update";
//		WebClient client = WebClient.create();
		Book block = webClient.put().
		uri("/update").
		bodyValue(book).
		retrieve().
		bodyToMono(Book.class).
		block();
		return block;
		
	}
	public Book updatePartial(Long id,Book book) {
//		String url = "http://localhost:8080/api/book/updateName/{id}";
//		WebClient client = WebClient.create();
		Book block = webClient.patch().
				uri("/delete",id).
				bodyValue(book).
				retrieve().
				bodyToMono(Book.class).
				block();
		
		return block;
	}
	
	public Book deleteBook(Long id) {
		webClient.delete().uri("/delete/{id}",id).retrieve().toBodilessEntity().block();
		return null;
	}
	
}
