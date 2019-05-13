package com.java.concepts.hashmap;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TestString {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	int count= 0;
    	 int alength = a.length();
         int blength = b.length();
         int intArr1[] = new int[26];
         int intArr2[] = new int[26];
        
        for(int i=0;i<alength;i++){
        	System.out.println("*****************: "+(a.charAt(i)-'a'));
            intArr1[a.charAt(i)-'a']++;
        }
        
        for(int i=0;i<blength;i++){
            intArr2[b.charAt(i)-'a']++;
        
        }
        for(int i=0;i<26;i++){
        	System.out.println("&&&&&&&&&&:" +(b.charAt(i)-'a'));
            count+=Math.abs(intArr1[i]-intArr2[i]);
        }

    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = "abcaa";

        String b = "cdeaq";
        int res = makeAnagram(a, b);
        System.out.println(res);

       /* bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}