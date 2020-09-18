package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return(args) -> {
			
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Non-fiction"));
			crepository.save(new Category("Poetry"));

			
			Book b1 = new Book("One", "One Oneson", 2019, "2019-1", 100.00, crepository.findByName("Fiction").get(0));
			Book b2 = new Book("Two", "Two Twoson", 2020, "2020-1", 400.00, crepository.findByName("Poetry").get(0));
			Book b3 = new Book("Three", "Three Threeson", 2020, "2020-2", 500.00, crepository.findByName("Non-fiction").get(0));
			
			brepository.save(b1);
			brepository.save(b2);
			brepository.save(b3);
			
			};
		}
	}

