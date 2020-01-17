package com.example.demo.dao;

import java.util.*;

public class Author {
		private int authorId;
		private String authorName;
		private String authorAddress;
		private List<Book> bookList;
		public int getAuthorId() {
			return authorId;
		}
		public void setAuthorId(int authorId) {
			this.authorId = authorId;
		}
		public String getAuthorName() {
			return authorName;
		}
		public void setAuthorName(String authorName) {
			this.authorName = authorName;
		}
		public String getAuthorAddress() {
			return authorAddress;
		}
		public void setAuthorAddress(String authorAddress) {
			this.authorAddress = authorAddress;
		}
		public List<Book> getBookList() {
			return bookList;
		}
		public void setBookList(List<Book> bookList) {
			this.bookList = bookList;
		}
}