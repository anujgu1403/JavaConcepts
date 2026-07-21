package com.java.concepts.visa;

public class CustomArrayList{
    private int size;
    private final Object[] array;
    private int currentIndex = 0;

    CustomArrayList(int size){
        this.size = size;
        array= new Object[size];
    }

    public void add(Object item){
        if(array[currentIndex]!=null){
            currentIndex++;
        }
        array[currentIndex] = item;
    }

    public Object get(int index){
        if(index<0) {
            System.out.println("Invalid Index: " + index);
            throw new IndexOutOfBoundsException();
        }
        if(array[index]!=null){
                return (Object) array[index];
        }
        return null;
    }

    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList(3);
        customArrayList.add(10);
        customArrayList.add(20);
        customArrayList.add(30);
        System.out.println(customArrayList.get(2));
        System.out.println(customArrayList.size);
    }
}