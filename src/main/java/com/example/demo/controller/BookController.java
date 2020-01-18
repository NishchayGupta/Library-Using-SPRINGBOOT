package com.example.demo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dao.Book;
import com.example.demo.exception.LibraryNotFoundException;
import com.example.demo.service.BookDAOService;

@RestController
public class BookController {
	
	@Autowired
	private BookDAOService service;
	
	@GetMapping("/books")
	public List<Book> getAllBooks()
	{
		return service.getAllBooks();
	}
	
	@GetMapping("/book/{id}")
	public Resource<Book> getSingleBook(@PathVariable int id)
	{
		Book book = service.findOneBook(id);
		if(book == null)
		{
			throw new LibraryNotFoundException("id: " + id);
		}
		//"all-books", SERVER_PATH + "/books" 
		 Resource<Book> resource = new Resource<Book>(book);
		 ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllBooks());
		 ControllerLinkBuilder linkTo1 = linkTo(methodOn(this.getClass()).getSingleBook(id));
		 resource.add(linkTo.withRel("all-books"));
		 resource.add(linkTo1.withRel("single-book"));
		 return resource;
	}
	
	@PostMapping("/books")
	public ResponseEntity<Object> createBook(@Valid @RequestBody Book book)
	{
		Book bookSaved = service.createBook(book);
		
		URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/id")
					.buildAndExpand(bookSaved.getBookId())
					.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/book/{id}")
	public void deleteBook(@PathVariable int id)
	{
		Book book = service.removeBook(id);
		if(book == null)
		{
			throw new LibraryNotFoundException("id: " + id);
		}
	}
}