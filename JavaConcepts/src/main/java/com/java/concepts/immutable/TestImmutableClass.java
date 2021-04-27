package com.java.concepts.immutable;

public class TestImmutableClass {
    public static void main(String[] args) {
        Salary salary = new Salary("121231", "Ram", 232);
        System.out.println(salary +" "+salary.getEmpId() +" "+ salary.getName()+" "+salary.getSal());
        Salary salary1 = new Salary("121231", "Ram", 232);
        System.out.println(salary1 +" "+ salary1.getEmpId() +" "+ salary1.getName()+" "+salary1.getSal());
    }
}
