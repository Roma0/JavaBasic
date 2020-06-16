package com.ascending.algorithm;

public class Factorial {

    public static int solution(int n){
        if(n == 0) return 0;
        if (n == 1) return 1;
        return n * solution(n-1);
    }

    public static void main(String[] args) {
//        Factorial factorial = new Factorial();
        System.out.println(Factorial.solution(4));
    }
}
