package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dao.Author;
import com.example.demo.dao.Book;

@Component
public class AuthorDAOService {
private List<Author> authors = new ArrayList<>();
	
	private static int authorCount = 3;
	
	// To retrieve list of authors
	public List<Author> getAllAuthors()
	{
		return authors;
	}
	
	// To retrieve a single author
	public Author findOneAuthor(int id)
	{
		for(Author author: authors)
		{
			if(author.getAuthorId() == id)
			{
				return author;
			}
		}
		return null;
	}
	
	// To retrieve books for a single author
	public List<Book> findBook(int id)
	{
		for(Author author: authors)
		{
			if(author.getAuthorId() == id)
			{
				return author.getBookList();
			}
		}
		return null;
	}
	
	// To retrieve name of an author
	public String findNameOfAuthor(int id)
	{
		for(Author author: authors)
		{
			if(author.getAuthorId() == id)
			{
				return author.getAuthorName();
			}
		}
		return null;
	}
	
	// To create an author
	public Author createAuthor(Author auth)
	{
		if(auth.getAuthorId() == 0)
		{
			auth.setAuthorId(++authorCount);
		}
		authors.add(auth);
		return auth;
	}
	
	//To delete an author
	public Author removeAuthor(int id)
	{
		Iterator<Author> author = authors.iterator();
		while(author.hasNext())
		{
			Author auth = author.next();
			if(auth.getAuthorId() == id)
			{
				author.remove();
				return auth;
			}
		}
		return null;
	}
}