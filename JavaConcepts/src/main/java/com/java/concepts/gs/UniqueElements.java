package com.java.concepts.gs;

import java.util.HashSet;
import java.util.Set;

public class UniqueElements {

    public static void findUniqueElements(int[] input){

        Set<Integer> result = new HashSet<>();

        for(int entry: input){
            if (!result.contains(entry))
                result.add(entry);
        }

        for (int entry: result){
            System.out.print(entry+" ");
        }

    }
    public static void main(String[] args) {

        int[] input = {23,34,1,5,23,2,34,2,20};
        findUniqueElements(input);
    }

}
