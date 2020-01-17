package com.example.demo.service;

import java.util.*;
import org.springframework.stereotype.Component;

import com.example.demo.dao.Author;
import com.example.demo.dao.Book;

@Component
public class BookDAOService {

	private static List<Book> books = new ArrayList<>();
	
	private static int bookCount = 3;
	
	static {
		books.add(new Book(1, "Science", "20.20"));
		books.add(new Book(2, "Arts", "10.10"));
		books.add(new Book(3, "Accounts", "5.05"));
	}
	
	// To retrieve list of books
	public List<Book> getAllBooks()
	{
		return books;
	}
	
	// To retrieve a single book
	public Book findOneBook(int id)
	{
		for(Book book: books)
		{
			if(book.getBookId() == id)
			{
				return book;
			}
		}
		return null;
	}
	
	// To retrieve authors for a single book
	public List<Author> findAuthor(int id)
	{
		for(Book book: books)
		{
			if(book.getBookId() == id)
			{
				return book.getAuthorList();
			}
		}
		return null;
	}
	
	// To retrieve cost of a book
	public String findCostOfBook(int id)
	{
		for(Book book: books)
		{
			if(book.getBookId() == id)
			{
				return book.getBookCost();
			}
		}
		return null;
	}
	
	// To create a book
	public Book createBook(Book bk)
	{
		if(bk.getBookId() == 0)
		{
			bk.setBookId(++bookCount);
		}
		books.add(bk);
		return bk;
	}
	
	//To delete a book
	public Book removeBook(int id)
	{
		Iterator<Book> book = books.iterator();
		while(book.hasNext())
		{
			Book buk = book.next();
			if(buk.getBookId() == id)
			{
				book.remove();
				return buk;
			}
		}
		return null;
	}
}