package com.bookstore.bookstore.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByTitle(@Param("title") String title);
}
