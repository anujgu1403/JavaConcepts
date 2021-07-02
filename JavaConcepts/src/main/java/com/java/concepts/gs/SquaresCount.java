package com.java.concepts.gs;

public class SquaresCount {

    public int countSquares(int n){
        return n*(n+1)*(2*n+1)/6;
    }

    public static void main(String[] args) {
        SquaresCount squaresCount = new SquaresCount();
        System.out.println(squaresCount.countSquares(5));
    }
}
