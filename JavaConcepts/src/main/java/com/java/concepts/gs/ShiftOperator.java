package com.java.concepts.gs;

public class ShiftOperator {

    public static void main(String[] args) {
        int a = 8;

        System.out.println("Binary rep: "+ Integer.toBinaryString(a));
        int b= a<<5;
        System.out.println("Left shift: "+ b);

        b = a>>1;
        System.out.println("Right shift: "+b);
        System.out.println("Binary rep: "+ Integer.toBinaryString(b));

        b=a>>>5;
        System.out.println("Right shift with zero: "+b);
        System.out.println("Binary rep: "+ Integer.toBinaryString(b));
    }
}
