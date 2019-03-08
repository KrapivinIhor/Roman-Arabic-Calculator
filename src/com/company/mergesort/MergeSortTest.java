package com.company.mergesort;


import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {

    public static void main(String[] args) {

        int[] arrayForMergeSort=new Random().ints(-50, 50).limit(20).toArray();
        System.out.println(Arrays.toString(arrayForMergeSort));
        MergeSort.sorting(arrayForMergeSort,0,arrayForMergeSort.length-1);
        System.out.println();
        System.out.println(Arrays.toString(arrayForMergeSort));
    }
}

