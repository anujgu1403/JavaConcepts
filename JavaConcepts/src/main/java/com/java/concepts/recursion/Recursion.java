package com.java.concepts.recursion;

public class Recursion {

    private int fact(int number) {

      //  if (number!=0) // to produce stack over flow
            return number * fact(number - 1);
      /*  else {
            return 1;
        }*/
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.fact(10));
    }
}
