package com.example.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;

//@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
    private BookRepository brepository;

    @Test
    public void findByAuthorShouldReturnBook() {
        List<Book> books = brepository.findByTitle("One");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("One Oneson");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Four", "Four Fourson", 2020, "2020-1", 200.00, new Category("Horror"));
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
    @Test
    public void deleteBook() {
    	List <Book> books = brepository.findByTitle("One");
    	brepository.deleteById(books.get(0).getId());
    	assertThat(books.isEmpty());
    }    
}
