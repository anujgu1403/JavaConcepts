package com.java.concepts.nagarro;

public class Book {
	private int ISBN;
	private String author;
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(int iSBN, String author) {

		ISBN = iSBN;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", author=" + author + "]";
	}
	

}
