//Вычислить периметр и площадь прямоугольного треугольника по длинам а и b  двух катетов

package calculation.by.home.task;

import java.util.Scanner;

import static calculation.by.home.task.Constants.DEGREE_FROM_FOLRMULA_PERIMETR;
import static calculation.by.home.task.Constants.NUMBER_FROM_FORMULA_SQUARE;


public class CalculatingThePerimeter {
    public static void main(String[] args) {
        headerOutput();
        selectionCalculation();


    }

    public static double calculatePerimeter(int firsLeg, int secondLeg) {
        double perimetr;
        perimetr = Math.sqrt(Math.pow(firsLeg, DEGREE_FROM_FOLRMULA_PERIMETR) + Math.pow(secondLeg, DEGREE_FROM_FOLRMULA_PERIMETR)) + firsLeg + secondLeg;
        return perimetr;
    }

    public static double calculateSquare(int firsLeg, int secondLeg) {
        double square;
        square = NUMBER_FROM_FORMULA_SQUARE * firsLeg * secondLeg;
        return square;
    }


    public static void selectionCalculation() {
        int numberChoice;
        int firsLeg;
        int secondLeg;
        numberChoice = enterNumChoice();
        switch (numberChoice) {
            case (1):
                resultNumberChoise(numberChoice);
                firsLeg = enterFirstAndSecondLeg(1);
                secondLeg = enterFirstAndSecondLeg(2);
                calculationOutput(0, calculatePerimeter(firsLeg, secondLeg), numberChoice);
                break;
            case (2):
                resultNumberChoise(numberChoice);
                firsLeg = enterFirstAndSecondLeg(1);
                secondLeg = enterFirstAndSecondLeg(2);
                calculationOutput(calculateSquare(firsLeg, secondLeg), 0, numberChoice);
                break;
            case (0):
                resultNumberChoise(numberChoice);
                firsLeg = enterFirstAndSecondLeg(1);
                secondLeg = enterFirstAndSecondLeg(2);
                calculationOutput(calculateSquare(firsLeg, secondLeg), calculatePerimeter(firsLeg, secondLeg), numberChoice);
                break;

        }

    }

    public static void calculationOutput(double resultCalculationSquare, double resultCalculationPerimetr, int enterNumChoice) {
        switch (enterNumChoice) {
            case (1):
                System.out.println("Периметр треугольника равен: " + resultCalculationPerimetr);
                break;

            case (2):
                System.out.println("Площадь треугольника равен: " + resultCalculationSquare);
                break;
            default:
                System.out.println("Периметр треугольника равен: " + resultCalculationPerimetr + ", площадь треугольника равна " + resultCalculationSquare);
                break;
        }


    }

    public static void headerOutput() {
        System.out.println("Программа вычисляет периметр и площадь треугольника по значениям двух катетов.");
        System.out.println("Введите номер варианта расчета или ноль для расчета и периметра и площади треугольника:");
        System.out.println("Первый (1) - расчет периметра:");
        System.out.println("Второй (2) - расчет периметра:");
        System.out.println("Нулевой (0) - расчет периметра и площади:");
    }

    public static void resultNumberChoise(int numberChoice) {
        System.out.println("Выбран вариант: " + numberChoice);
    }


    public static int enterNumChoice() {
        Scanner in = new Scanner(System.in);
        int numberChoice;
        do {
            System.out.println("Введите число от 0 до 2 включительно!");
            while (!in.hasNextInt()) {
                System.out.println("Некорректный ввод!");
                in.next();
            }
            numberChoice = in.nextInt();
        } while (numberChoice != 0 && numberChoice != 1 && numberChoice != 2);
        return numberChoice;
    }

    public static int enterFirstAndSecondLeg(int numberLeg) {
        switch (numberLeg) {
            case (1):
                System.out.println("Введите первый катет:");
                break;
            case (2):
                System.out.println("Введите второй катет:");
                break;
        }
        Scanner in = new Scanner(System.in);
        int leg;
        while (!in.hasNextInt()) {
            System.out.println("Некорректный ввод!");
            System.out.print("Введите число ");
        }
        leg = in.nextInt();
        return leg;
    }

}
