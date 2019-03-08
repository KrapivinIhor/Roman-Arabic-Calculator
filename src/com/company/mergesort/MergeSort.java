package com.company.mergesort;

class MergeSort {

    static void sorting(int[] ints, int min, int max){
        if(max-min==0){
        }
        else if(max-min==1){
            if(ints[min]>ints[max])
                swap(ints,min,max);
        }
        else{
            int mid=((int) Math.floor((min+max)/2));
            sorting(ints,min,mid);
            sorting(ints,mid+1,max);
            merge(ints,min,max,mid);
        }
    }

    static void merge(int[]ints,int min,int max,int mid){
        int i=min;
        while(i<=mid){
            if(ints[i]>ints[mid+1]){
                swap(ints,i,mid+1);
                push(ints,mid+1,max);
            }
            i++;
        }
    }

    static void swap(int[] ints,int loc1,int loc2){
        ints[loc1]=ints[loc1]^ints[loc2];
        ints[loc2]=ints[loc1]^ints[loc2];
        ints[loc1]=ints[loc1]^ints[loc2];
    }

    static void push(int[] ints,int s,int e){
        for(int i=s;i<e;i++){
            if(ints[i]>ints[i+1])
                swap(ints,i,i+1);
        }
    }
}
