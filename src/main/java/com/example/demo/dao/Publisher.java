package com.example.demo.dao;

import java.util.*;

public class Publisher {
		private int publisherId;
		private String publisherName;
		private int publishBookCount;
		private List<Book> publishBook;
		public int getPublisherId() {
			return publisherId;
		}
		public void setPublisherId(int publisherId) {
			this.publisherId = publisherId;
		}
		public String getPublisherName() {
			return publisherName;
		}
		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}
		public int getPublishBookCount() {
			return publishBookCount;
		}
		public void setPublishBookCount(int publishBookCount) {
			this.publishBookCount = publishBookCount;
		}
		public List<Book> getPublishBook() {
			return publishBook;
		}
		public void setPublishBook(List<Book> publishBook) {
			this.publishBook = publishBook;
		}
}