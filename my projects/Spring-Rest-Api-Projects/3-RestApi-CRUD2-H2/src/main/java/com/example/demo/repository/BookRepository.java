package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Books;

public interface BookRepository extends JpaRepository<Books, Long> {
	

}
