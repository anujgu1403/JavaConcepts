package com.java.concepts.immutable;

public final class Salary {

    private final String empId;
    private final String name;
    private final int sal;

    public Salary(String empId, String name, int sal){
        this.empId = empId;
        this.name=name;
        this.sal=sal;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public int getSal() {
        return sal;
    }
}
