package com.example.demo.dao;

public class Written {
		private int bookId; 
		private int authorId; 
		private int booksByAuthorCount; //count of books written by an author
		private int bookAuthors; //count of authors for a book
		public int getBookId() {
			return bookId;
		}
		public void setBookId(int bookId) {
			this.bookId = bookId;
		}
		public int getAuthorId() {
			return authorId;
		}
		public void setAuthorId(int authorId) {
			this.authorId = authorId;
		}
		public int getBooksByAuthorCount() {
			return booksByAuthorCount;
		}
		public void setBooksByAuthorCount(int booksByAuthorCount) {
			this.booksByAuthorCount = booksByAuthorCount;
		}
		public int getBookAuthors() {
			return bookAuthors;
		}
		public void setBookAuthors(int bookAuthors) {
			this.bookAuthors = bookAuthors;
		}
}