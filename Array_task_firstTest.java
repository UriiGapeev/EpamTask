package com.company.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_task_firstTest {
    @Test
    public void arrayFillInT001(){
        Integer[] arr = new Integer[]{1,2, 3, 4, 5, 6, 7,9};
        int elementToBeDeleted =  10;
        Integer[] testMassive ;
        Integer[] realMassive ;
        testMassive = arrayInputZeroTwoElementsTest(arr,elementToBeDeleted);
        realMassive = Array_task_first.arrayInputZeroTwoElements(arr,elementToBeDeleted);
        Assert.assertArrayEquals(testMassive,realMassive);
    }
    @Test
    public void arrayFillInT002(){
        Integer[] arr = new Integer[]{3, 1, 6, 5, 2, 8, 4};
        int elementToBeDeleted =  4;
        Integer[] testMassive ;
        Integer[] realMassive ;
        testMassive = arrayInputZeroTwoElementsTest(arr,elementToBeDeleted);
        realMassive = Array_task_first.arrayInputZeroTwoElements(arr,elementToBeDeleted);
        Assert.assertArrayEquals(testMassive,realMassive);
    }
    public static Integer[] arrayInputZeroTwoElementsTest(Integer[] arr, int elementToBeDeleted){
        for (int i = 0; i < arr.length; i++) {
            if (i %2 != 0) {
                arr[i] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr = removeElementUsingCollectionTest(arr, i);

            }
        }
        return arr;
    }
    public static Integer[] removeElementUsingCollectionTest( Integer[] arr, int index ){
        List<Integer> tempList = new ArrayList<Integer>(Arrays.asList(arr));
        tempList.remove(index);
        return tempList.toArray(new Integer[0]);
    }
    public void outPutAllArray(Integer[] arr){
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                System.out.print(arr[i]);

            }
        }
    }
}
