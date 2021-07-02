package com.java.concepts.hackerrank;

public class Triplet {

    public boolean increasingTriplet(int[] arr){

        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int number: arr){
            if(number>mid)
                return true;
            else if(number<mid && number>left)
                mid = number;
            else
                left = number;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {2,3,60,4,5,10,7};
        Triplet triplet = new Triplet();
        System.out.println(triplet.increasingTriplet(input));
    }
}
