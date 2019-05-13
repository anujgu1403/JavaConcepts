package com.java.concepts.hashmap;

public final class Employee {

	private String id;
	private String name;
	
	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee e = (Employee) obj;
        if(!this.id.equals(e.id))
        	return false;
        return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        
        result = prime * result + Integer.parseInt(id);
        return result;
	}
	
	
}
