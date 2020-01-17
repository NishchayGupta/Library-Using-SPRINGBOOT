package com.example.demo.dao;

import java.util.*;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class Book {
	
		private int bookId;
		@Size(min = 3, message = "The name should have atleast 3 characters")
		private String bookName;
		@PositiveOrZero
		private String bookCost;
		private List<Author> authorList;
		
		public Book(int bookId, String bookName, String bookCost) {
			super();
			this.bookId = bookId;
			this.bookName = bookName;
			this.bookCost = bookCost;
		}
		public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getBookCost() {
			return bookCost;
		}
		public void setBookCost(String bookCost) {
			this.bookCost = bookCost;
		}
		public List<Author> getAuthorList() {
			return authorList;
		}
		public void setAuthorList(List<Author> authorList) {
			this.authorList = authorList;
		}
		@Override
		public String toString() {
			return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookCost=" + bookCost + "]";
		} 
}