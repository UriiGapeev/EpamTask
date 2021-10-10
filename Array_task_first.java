package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_task_first {
    Integer[] arr;
    int elementToBeDeleted;
    public  Array_task_first(){
        this.arr = new Integer[]{};
        this.elementToBeDeleted =  0;
    }
    public  Array_task_first(Integer[] arr, int elementToBeDeleted){
        this.arr = arr;
        this.elementToBeDeleted =  elementToBeDeleted;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        Array_task_first array_task_first1 =  new Array_task_first();
        Integer[] arr = new Integer[]{3, 1, 6, 5, 2, 8, 4};
        int elementToBeDeleted =2;
        array_task_first1.setElementToBeDeleted(elementToBeDeleted);
        array_task_first1.setArr(arr);
        Array_task_first array_task_first =  new Array_task_first(arr,elementToBeDeleted);

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

    public void setElementToBeDeleted(int elementToBeDeleted) {
        this.elementToBeDeleted = elementToBeDeleted;
    }
}