package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_task_first {
    Integer[] arr;
    int elementToBeDeleted;
    public  Array_task_first(){
        this.arr = new Integer[]{3, 1, 6, 5, 2, 8, 4};
        this.elementToBeDeleted =  2;
    }
    public static void main(String[] args) {
        Array_task_first array_task_first =  new Array_task_first();
        outputBeforeArrayDeleteeEements(array_task_first.arr,array_task_first.elementToBeDeleted);
        array_task_first.arr = arrayInputZeroTwoElements(array_task_first.arr ,array_task_first.elementToBeDeleted);
        outputAfterArrayDeleteeEements(array_task_first.arr,array_task_first.elementToBeDeleted);
    }

    public static Integer[] arrayInputZeroTwoElements(Integer[] arr, int elementToBeDeleted){
        for (int i = 0; i < arr.length; i++) {
            if (i %2 != 0) {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr = removeElementUsingCollection(arr, i);

            }
        }
        return arr;
    }
    public static Integer[] removeElementUsingCollection( Integer[] arr, int index ){
        List<Integer> tempList = new ArrayList<Integer>(Arrays.asList(arr));
        tempList.remove(index);
        return tempList.toArray(new Integer[0]);
    }
    public static void outputBeforeArrayDeleteeEements(Integer[] arr,int elementToBeDeleted) {
        System.out.println("Array before removing element : "+elementToBeDeleted+ " -- ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

    }

    public static void outputAfterArrayDeleteeEements(Integer[] arr,int elementToBeDeleted) {
        System.out.println("");
        System.out.println("Array after removing element : "+elementToBeDeleted+ " -- ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

    }
}