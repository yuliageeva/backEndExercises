package com.bookstore.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookstore.bookstore.domain.Book;
import com.bookstore.bookstore.domain.BookRepository;
import com.bookstore.bookstore.domain.CategoryRepository;


@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	
	@RequestMapping(value ="/booklist", method = RequestMethod.GET)
	public String bookList(Model model){
		model.addAttribute("bookList",repository.findAll());
		return "booklist";
	}
	 
	 @RequestMapping(value="/add")
	 public String addAttribute(Model model){
		 model.addAttribute("book", new Book());
		 model.addAttribute("categories",crepository.findAll());
		 return "addBook";
	 }
	 
	 @RequestMapping(value="/save", method = RequestMethod.POST)
	 public String save(Book book){
		 repository.save(book);
		 return "redirect:booklist";
	 }
	 
	 @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	 public String deleteBook(@PathVariable("id") Long bookId, Model model){
		 repository.delete(bookId);
		 return "redirect:../booklist";
	 }
	 
	 @RequestMapping(value="/edit/{id}")
	 public String editBook(@PathVariable("id") Long bookId, Model model){
		 model.addAttribute("categories",crepository.findAll());
		 model.addAttribute("editbook", repository.findOne(bookId));
		 return "editBook";
	 }
	 
	 @RequestMapping(value="/books", method = RequestMethod.GET)
		 public @ResponseBody List<Book> bookListRest(){
			 return(List<Book>) repository.findAll();
		 }
	 
	 @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	 	public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
		 return repository.findOne(bookId);
	 }
	 
	 @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	 	public @ResponseBody Book findCatRest(@PathVariable("id") Long categoryId) {
		 return repository.findOne(categoryId);
	 }
	 
	 @RequestMapping(value="/books", method = RequestMethod.POST)
	 public @ResponseBody Book addBook(@RequestBody Book b){
		 repository.save(b);
		 return b;
	 }
	 
	 @RequestMapping(value={"/","/booklist"})
	 public String booklistSecure(){
		 return "booklist";
	 }
	 
	 @RequestMapping(value="/login")
	 public String login(){
		 return "login";
	 }
	 
	 
//	 @PostMapping(path= "/books", consumes = "application/json")
//	 	public void addBook(@RequestBody Book book){
//		 System.out.print(book);
//	 }
//	 
}
