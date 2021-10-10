package com.company.array;

import java.util.Scanner;

public class Array_task_second{
    int n;
    int [][]mas;
    public Array_task_second(){
        this.n = arrayInput();;
        this.mas = new int[n][n];
    }
    public static void main(String[] args) {
        Array_task_second array_task_second = new Array_task_second();
        array_task_second.mas = arrayFillIn(array_task_second.mas);
        arrayOutput(array_task_second.mas);
    }
    public static int arrayInput(){
        System.out.println("Entet rize array:");
        Scanner in = new Scanner(System.in);
        int numberRizeArray;
        numberRizeArray = in.nextInt();
        return numberRizeArray;
    }
    public static int[][] arrayFillIn(int[][] mas){
        for (int i = 0; i < mas.length; i=i+1) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = j+1;
                mas[i][j] = (int) Math.pow(mas[i][j] ,i+1);
            }
        }
        return mas;
    }
    public static void arrayOutput(int[][] mas){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.printf("%8d ", mas[i][j]);
            }
            System.out.println();
        }
    }
}
