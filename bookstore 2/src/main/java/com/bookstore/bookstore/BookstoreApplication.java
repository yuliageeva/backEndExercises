package com.bookstore.bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.bookstore.domain.Book;
import com.bookstore.bookstore.domain.BookRepository;
import com.bookstore.bookstore.domain.Category;
import com.bookstore.bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log= LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner Demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save few books");
			Category category1 = new Category("Fiction");
			 crepository.save(category1);
			 Category category2 = new Category("Romance");
			 crepository.save(category2);
			 Category category3 = new Category("Classic");
			 crepository.save(category3);
			
			 Book book1 = new Book("Robinson Crusoe","Daniel Defore",1719,"978-1629100746",20.00, crepository.findByName("Classic").get(0));
			 repository.save(book1);
			 
			 Book book2 = new Book("Gulliver's Travels", "Jonathan Swift",1726,"978-0486292731", 17.00, crepository.findByName("Classic").get(0));
			 repository.save(book2);
			 
			 Book book3 = new Book("Kitchens of the great Midwest", "Ryan Stradal", 2017, "978-1629100456",15.00, crepository.findByName("Romance").get(0));
			 repository.save(book3);
			 
			 log.info("fetch all books");
			 for (Book book : repository.findAll()) {
				 //log.info(book.toString());
			 }
			 
			 
		};
	}
}
