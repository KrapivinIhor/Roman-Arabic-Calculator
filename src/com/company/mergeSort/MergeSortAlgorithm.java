package com.company.mergeSort;

import java.util.Arrays;

class MergeSortAlgorithm {

    static int[] sort(int[] array){
        if(array.length < 2) return array;
        int length = array.length / 2;
        int[] firstArray = Arrays.copyOfRange(array, 0, length);
        int[] secondArray = Arrays.copyOfRange(array, length, array.length);
        return merge(sort(firstArray), sort(secondArray));
    }

    private static int[] merge(int[] firstArray, int secondArray[]){
        int length = firstArray.length + secondArray.length;
        int[] summaryArray = new int[length];
        int firstIndex=0;
        int secondIndex=0;
        for(int i=0;i<length;i++){
            if(firstIndex == firstArray.length){
                summaryArray[i] = secondArray[secondIndex++];
            }else if(secondIndex == secondArray.length){
                summaryArray[i] = firstArray[firstIndex++];
            }else{
                if(firstArray[firstIndex] < secondArray[secondIndex]){
                    summaryArray[i] = firstArray[firstIndex++];
                }else{
                    summaryArray[i] = secondArray[secondIndex++];
                }
            }
        }
        return summaryArray;
    }
}
