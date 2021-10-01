import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
    }

    private static void task1() {

            // Первая задача, первый способ
            Integer aaa = 2045;
            Integer bbb = 5115;
            Integer firstSimbolA = Integer.valueOf(aaa.toString(aaa).substring(0, 1));
            Integer secondSimbolA = Integer.valueOf(aaa.toString(aaa).substring(1, 2));
            Integer threeSimbolA = Integer.valueOf(aaa.toString(aaa).substring(2, 3));
            Integer fourSimbolA = Integer.valueOf(aaa.toString(aaa).substring(3));

                if(firstSimbolA +secondSimbolA ==threeSimbolA +fourSimbolA)

            {
                System.out.println("true");
            } else

            {
                System.out.println("false");
            }

            Integer firstSimbolB = Integer.valueOf(bbb.toString(bbb).substring(0, 1));
            Integer secondSimbolB = Integer.valueOf(bbb.toString(bbb).substring(1, 2));
            Integer threeSimbolB = Integer.valueOf(bbb.toString(bbb).substring(2, 3));
            Integer fourSimbolB = Integer.valueOf(bbb.toString(bbb).substring(3));

                if(firstSimbolB +secondSimbolB ==threeSimbolB +fourSimbolB)

            {
                System.out.println("true");
            } else

            {
                System.out.println("false");
            }

            // Первая задача, второй способ
            String str = bbb.toString(bbb);
            char[] strToArray = str.toCharArray();
                if(Integer.valueOf(strToArray[0])+Integer.valueOf(strToArray[1])==Integer.valueOf(strToArray[2])+Integer.valueOf(strToArray[3]))

            {
                System.out.println("true");
            } else

            {
                System.out.println("false");
            }

    }
    private static void task2() {
        //Вторая задача
        double a = 2.2;
        double b = 3.6;
        double c = 5.2;
        double result;
        result = (b + (Math.sqrt(Math.pow(b, 2) + 4 * a * c) + b)) / (2 * a) - Math.pow(a, 3) + Math.pow(b, -2);
        System.out.println("Результат выражения: " + result);

    }
    private static void task3() {
        //Третья задача
        double firsLeg = 2.2;
        double secondLeg = 2.2;
        double perimetr;
        double square;
        perimetr = Math.sqrt(Math.pow(firsLeg, 2) + Math.pow(secondLeg, 2)) + firsLeg + secondLeg;
        square = 0.5 * firsLeg * secondLeg;
        System.out.println("Периметр треугольника: " + perimetr);
        System.out.println("Площадь выражения: " + square);

    }
        //четвертая задача
    private static void task4() {
        System.out.println("Введите координаты: ");
        Scanner in = new Scanner(System.in);
        int x = scannerInt();
        int y = scannerInt();

        int y1 = 4;
        int x1 = 2;
        int x2 = -2;

        int y2 = -3;
        int x3 = 4;
        int x4 = -4;

        if (((x < x1 && x > x2) && (y < y1 && y > y2)) || ((x < x3 && x > x4) && (y < y1 && y > y2))) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    //пятая задача
    private static void task5() {
      double[] mnumberMassive = new double[]{-5.5,6.6,2.1};
      for(int i =0 ; i<=mnumberMassive.length-1; i++){
          if(mnumberMassive[i]>0){
              System.out.println(Math.pow(mnumberMassive[i],2));
          }
          else{ System.out.println(Math.pow(mnumberMassive[i],4));}
      }
    }
    //шестая задача
    private static void task6() {
        int[] age = {2, 6, };
        int max = age[0];
        for (int i = 1; i < age.length; i++){ max = Math.max(max, age[i]);}
        System.out.println(max);;
    }

    //седьмая задача
    private static void task7() {
        double a = 0.0;
        double b = 4;
        double h = 0.5;
        double y = 0.0;

        System.out.println(" -----------------------");
        System.out.println("|     x     |     y     |");

        for (double i = a; i <= b; i += h) {

            y = 2*Math.sin(i)-Math.cos(2*i);
            System.out.println(" -----------------------");
            System.out.printf("|%-11f|%-11f|\n", i , y);
        }

        System.out.println(" -----------------------");
        System.out.println();
    }

    //восьмая задача
    private static void task8() {
        int k = 2;

        int[] mas= new int[10];
        int summ =0;

        Random rand = new Random();
        for (int i = 0; i < mas.length; i++) {
            mas[i] = rand.nextInt(10);
        }

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] % k == 0) {
                summ += mas[i];
            }
        }

        System.out.println("Сумма элементов, которые кратны " + k + ", равна " + summ);
    }

    //девятая задача
    private static void task9() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6,7,8,9,0,1,2,3,4,5,6,7};
        int[] b = new int[]{11, 12, 13, 14,16};
        int k = 3-1;
        int l = 0;
        int c = k;
        ArrayList list = new ArrayList(10);
        for(int i = 0; i< a.length; i++) {
            if(c == i){
                if(l<b.length){
                list.add(b[l]);
                    }
                l= l+1;
                list.add(a[i]);

                c = i+k;
                }
            else{
            list.add(a[i]);}
        }

        for(int j = 0; j< list.size(); j++) {
            System.out.print(list.get(j)+" ");
        }

    }
    private static void task10() {
        int n = enterNum();
        int[][] matr = new int[n][n];
        form(matr);
        print(matr);
    }
    public static int enterNum() {
        int num;
        while (true) {
            System.out.print("Введите число n: ");
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if(num > 1){
                    if(num % 2 == 0)
                        break;
                    else System.out.print("нечетное число, не подходит по условию!  ");
                }else{
                    System.out.print("Число отрицательное или меньше 2, повторите ввод!  ");
                }
            }else{
                System.out.print("Некорректное значение, повторите ввод!  ");
            }
        }
        return num;
    }

    public static void form(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            if(i % 2 == 0){
                for(int j = 0; j < mat[i].length; j++){
                    mat[i][j] = j+1;
                }
            }else{
                for(int j = 0; j < mat[i].length; j++){
                    mat[i][j] = mat[j].length - j;
                }
            }
        }


    }

    public static void print(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                System.out.printf("%3d", mat[i][j]);
            }
            System.out.println();
        }


    }
        //считывает числа
    private static int scannerInt(){
        Scanner in = new Scanner(System.in);
        int number;
        System.out.print("Введите число: ");
        while (!in.hasNextInt()) {
            in.next();
            System.out.println("Некорректный ввод!");
            System.out.print("Введите число: ");
        }
        number = in.nextInt();
        return number;
    }
}
