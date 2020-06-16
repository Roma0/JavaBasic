package com.ascending.algorithm;

public class BinarySearch {
    private int[] arr = new int[10];

    //Todo
    public void binarySearchRecursive(int[] arr, int target, int left, int right){

        for (int i=0; i<arr.length; i++){
            if (left == right) {
                return;
            }
            int mid = left + (right-left)/2;
            if(arr[mid] == target) return;
            if(arr[mid] > target) {
                binarySearchRecursive(arr, target, mid+1, right);
            }
            else {
                binarySearchRecursive(arr, target, left, right-1);
            }
        }
    }
}
