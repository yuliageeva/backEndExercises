package com.bookstore.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.bookstore.domain.Book;
import com.bookstore.bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("Robinson Crusoe","Daniel Defore",1719,"978-1629100746",20.00);
			 repository.save(book1);
			 
			 Book book2 = new Book("Gulliver's Travels", "Jonathan Swift",1726,"978-0486292731", 17.00);
			 repository.save(book2);
			 
			 Book book3 = new Book("Kitchens of the great Midwest", "Ryan Stradal", 2017, "978-1629100456",15.00);
			 repository.save(book3);
		};
	}
}
