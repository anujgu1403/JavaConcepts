package com.java.concepts.treemap;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class DecendingOrderTreeMap {

	public static void main(String[] args) {
		Map<String, String> nameMap = new TreeMap<String, String>(Collections.reverseOrder());
		nameMap.put("Anuj", "Kunar");
		nameMap.put("Shuchi", "Gupta");
		nameMap.put("Raksham", "Mittal");
		nameMap.put("Test", "123");
		nameMap.put("Bhanu", "Kunar");
		nameMap.put("Kamboj", "Manoj");
		
		Set<String> keySet = nameMap.keySet();
		for(String key: keySet) {
			System.out.println(key+" "+nameMap.get(key));
		}
	}

}
