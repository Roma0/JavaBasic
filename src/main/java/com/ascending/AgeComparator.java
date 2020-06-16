package com.ascending;


import java.util.Arrays;

public class AgeComparator {
    int[] ints = {1,3,4,5,2};
    int max = Arrays.stream(ints).max().getAsInt();
}
