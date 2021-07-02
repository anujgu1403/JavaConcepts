package com.java.concepts.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TestInstanceOf {
    public static void main(String[] args) throws ClassNotFoundException {
        Integer i = new Integer(5);
        boolean b = i instanceof Integer;
        System.out.println(b);

        boolean b1 = test(i, "java.lang.Integer");
        System.out.println(b1);
        boolean b2 = test(i, "java.lang.String");
        System.out.println(b2);
        boolean b3 = test(i, "java.lang.Number");
        System.out.println(b3);

        List<String> list = new ArrayList<>();
    }

    private static boolean test(Object obj, String c) throws ClassNotFoundException {

        return Class.forName(c).isInstance(obj);
    }
}
