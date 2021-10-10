package com.company.array;
import org.junit.Assert;
import org.junit.Test;

public class Array_task_secondTestSecond {
    @Test
    public void arrayFillInT002(){
        int n = 10;
        int[][] realMassive = new int[n][n];
        int[][] testMassive = new int[n][n];
        testMassive = arrayFillInTest2(testMassive);
        realMassive = Array_task_second.arrayFillIn(realMassive);
        Assert.assertArrayEquals(testMassive,realMassive);
    }
    public static int[][] arrayFillInTest2(int[][] mas){
        for (int i = 0; i < mas.length; i=i+1) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = j+1;
                mas[i][j] = (int) Math.pow(mas[i][j] ,i+1);
            }
        }
        return mas;
    }


}
