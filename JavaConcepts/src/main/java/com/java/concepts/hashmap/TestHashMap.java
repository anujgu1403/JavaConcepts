package com.java.concepts.hashmap;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class TestHashMap {

	public static void main(String[] args) {
		Map<Employee, String> empMap = new WeakHashMap<Employee, String>(5);
		Employee e1 = new Employee("1", "Anuj"); 
		Employee e2 = new Employee("2", "Kumar");

		Employee e4 = new Employee("2", "Kumar");
		empMap.put(e1, "India");
		empMap.put(e2, "UK");
		empMap.put(e4, "Japan");
		System.out.println("empMap: "+empMap);
		
		Collections.synchronizedMap(empMap);
		e1=null;
		System.gc();
		System.out.println("After mutate the state of key empMap: "+empMap);	
		System.out.println("E2 data: "+empMap.get(e4));
		
		empMap.put(null, "USA");
		System.out.println("Having null key: "+empMap);

	}

}
