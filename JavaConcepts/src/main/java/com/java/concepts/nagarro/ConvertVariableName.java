package com.java.concepts.nagarro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertVariableName {

	
	public static void main(String[] args) {
		System.out.println(convertString("new_Star_result_bo"));
	}

	public static String convertString(String value){
	    String result="";
	    if (value.contains("_")){
	        result=value;
	        String regex = "\\_([a-z])";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(result);
	        while (matcher.find()) {
	            result = result.replaceFirst(matcher.group(), matcher.group(1).toUpperCase());
	        }
	        return result;
	    }else {
	    for (int i = 0; i <value.length() ; i++) {
	        result = result + value.charAt(i);
	        if (Character.isUpperCase(value.charAt(i))) {
	            result = result.substring(0, result.length() - 1);
	            char ch = value.charAt(i);
	            result = result + "_" + Character.toLowerCase(ch);
	        }
	    }
	    }return result;
	}
}
