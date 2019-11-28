package com.java.concepts.nagarro;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {

	public static void main(String[] args) {
		List<String> cardsList = Arrays.asList("Visa","Amex", "Rupey","Mastercard","Visa");
		Map<String, Integer> cardsMap = cardsList.stream().collect(Collectors.toMap(Function.identity(), String::length));
		System.out.println("cardsMap: "+cardsMap.values());

	}
}
