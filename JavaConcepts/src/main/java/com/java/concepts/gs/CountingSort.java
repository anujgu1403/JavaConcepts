package com.java.concepts.gs;


//Worst Case Complexity: O(n+k)
//Best Case Complexity: O(n+k)
//Average Case Complexity: O(n+k)
public class CountingSort {

    //To sort char array
    public void charSorting(char input[]) {
        int n = input.length;
        char[] output = new char[n];

        // Create an array of 256 size to store count the frequency of char and assign with 0
        int[] count = new int[256];
        for (int i = 0; i < 256; i++)
            count[i] = 0;

        //Count the frequency of char in input array
        for (int i = 0; i < n; i++)
            count[input[i]]++;

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        //Computing cumulative sum
        for (int i = 1; i <= 255; i++)
            count[i] += count[i - 1];

        //Assign the chars in output array by operating in reverse order
        for (int i = n - 1; i >= 0; i--) {
            output[count[input[i]] - 1] = input[i];
            count[input[i]]--;
        }

        //Print the output array
        for (int i = 0; i < n ; i++)
            System.out.print(output[i] + " ");
    }

    public void sortInts(int input[]) {
        int n = input.length;

        int[] count = new int[13];
        int[] output = new int[n];

        for (int i = 0; i <= 12; i++)
            count[i] = 0;

        for (int i = 0; i < n; i++) {
            count[input[i]]++;
        }

        //Computing cumulative sum which will tell how many elements we have <= to index
        //3 element <=3 etc
        for (int i = 1; i <=12; i++)
            count[i] = count[i] + count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[input[i]]-1] = input[i];
            count[input[i]]--;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(output[i] + " ");
        }
    }

    public static void main(String[] args) {

        char[] input = {'f', 'b', 'a', 'd', 'w', 'c', 'v', 'n', 'z'};
        CountingSort cs = new CountingSort();
        cs.charSorting(input);

        System.out.println("\n***************");

        int[] ints = {4,1,3,12,2,10,2};
        cs.sortInts(ints);

    }
}
