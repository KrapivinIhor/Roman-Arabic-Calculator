package com.company.mergeSort;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] arrayForMergeSort = new Random().ints(-50, 50).limit(20).toArray();
        System.out.print(Arrays.toString(arrayForMergeSort));
        int[] afterSortingArray = MergeSortAlgorithm.sort(arrayForMergeSort);
        System.out.println();
        System.out.println();
        System.out.print(Arrays.toString(afterSortingArray));
    }
}
