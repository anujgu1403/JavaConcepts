package com.java.concepts.nagarro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {
		List<String> cardsList = Arrays.asList("Visa", "Amex", "Rupey", "Mastercard", "Visa");
		Map<String, Integer> cardsMap = cardsList.stream()
				.collect(Collectors.toMap(Function.identity(), String::length, (t1, t2) -> t1, LinkedHashMap::new));
		System.out.println("cardsMap: " + cardsMap);
		
		
		List<Book> bookList= new ArrayList<Book>();
		bookList.add(new Book(1,"Anuj"));
		bookList.add(new Book(2,"Ayushi"));
		bookList.add(new Book(3,"Shuchi"));
		bookList.add(new Book(4,"Manoj"));
		bookList.add(new Book(5,"Raksham"));
		
		Map<Integer, Book> bookMap = bookList.stream().filter(book->book.getISBN()>3).collect(Collectors.toMap(Book::getISBN, book->book));
		System.out.println(bookMap.values());

	}
}