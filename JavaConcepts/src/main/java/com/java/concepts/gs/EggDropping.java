package com.java.concepts.gs;

import java.util.Arrays;

public class EggDropping {

    //Using recursion
    public static int findMinimumTries(int n, int k){

        if(k==0 || k==1){
            return k;
        }

        if(n==1)
            return k;

        int min = Integer.MAX_VALUE;

        int x, result;

        for (x=1; x<k; x++){
            result = Math.max(findMinimumTries(n-1, x-1), findMinimumTries(n, k-x));

            if(result<min)
                min=result;
        }
        return  min+1;
    }

    //Using Dynamic Programming
    public static int eggDropMinimumTries(int n, int k){

        int[][] result = new int[n+1][k+1];

        for(int i=0; i<n+1; i++){
            result[i][1] = i;
        }

        for (int i=0; i<k+1; i++){
            result[1][i] = 1;
        }

        for (int i=2; i<n+1; i++){
            for (int j=2; j<k+1; j++){
                result[i][j]= Integer.MAX_VALUE;

                for(int x=1; x<i; x++){
                    final int eggBrokenResult= result[x-1][j-1];
                    final int eggSurviveResult = result[i-x][j];

                    int temp = Math.max(eggBrokenResult, eggSurviveResult)+1;
                            if(temp<result[i][j]){
                                result[i][j]=temp;
                            }
                }
            }
        }
        for (int[] a: result ){
            System.out.println(Arrays.toString(a));
        }
        return result[n][k];
    }
    public static void main(String[] args) {
        int n=2, k=8;
        System.out.println("Minimum tries: "+ findMinimumTries(n, k));

        System.out.println("Minimum tries: "+ eggDropMinimumTries(8, 4));
    }
}
