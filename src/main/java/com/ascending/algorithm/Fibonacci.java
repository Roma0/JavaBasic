package com.ascending.algorithm;

public class Fibonacci {
    public int recur(int n){
        if(n <= 0) return 0;
        if(n == 1) return 2;
        if(n == 2) return 6;

        return recur(n-1) + recur(n-2);
    }

    public int recur2(int n){
        if(n <= 0) return 0;
        if(n == 1) return 1;
        return recur2(n-1) + recur2(n-2);
    }

    public int recurWithMem(int n, int[] men){
        if(men[n] > 0) return men[n];
        if (n <= 0) return 0;
        if (n == 1) {men[n] =2; return men[n];}
        if (n == 2) {men[n] =6; return men[n];}

        men[n] = recurWithMem(n-1, men) + recurWithMem(n-2, men);

        return men[n];
    }

    public int forLoop(int n){
        int[] temp = new int[n];
        temp[0] = 2;
        temp[1] = 6;
        for (int i = 2; i < n; i++){
            temp[i] = temp[i-1] + temp[i-2];
        }

//        System.out.println(temp.length);
        return temp[n-1];
    }

    public static void main(String[] arg){
        Fibonacci fibonacci = new Fibonacci();
        int n = 40;

        System.out.println(fibonacci.recur2(n));
        long startTime1 = System.nanoTime();
        System.out.println(fibonacci.recur(n));
        long endTime1 = System.nanoTime();
        System.out.println(endTime1 - startTime1);

        long startTime2 = System.nanoTime();
        int[] temp = new int[n+1];
        System.out.println(fibonacci.recurWithMem(n,temp));
        long endTime2 = System.nanoTime();
        System.out.println(endTime2 - startTime2);

        long startTime3 = System.nanoTime();
        System.out.println(fibonacci.forLoop(n));
        long endTime3 = System.nanoTime();
        System.out.println(endTime3 - startTime3);
    }
}
