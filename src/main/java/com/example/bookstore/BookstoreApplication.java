package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return(args) -> {
			Book b1 = new Book("One", "One Oneson", 2019, "2019-1", 100.00);
			Book b2 = new Book("Two", "Two Twoson", 2020, "2020-1", 400.00);
			Book b3 = new Book("Three", "Three Threeson", 2020, "2020-2", 500.00);
			
			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
			
			};
		}
	}

