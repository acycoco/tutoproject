package com.example.tutoopjdbc;

public class MyUtils {
    public static void game369Ex() {
        int cnt = 333;
        String result = is369(cnt);
        System.out.println(cnt + result);
    }

    private static void game369T() {
        for (int cnt = 0; cnt < 100; cnt++) {
            System.out.print(cnt + "");
            int a = cnt / 10;
            int b = cnt % 10;
            if (a != 0 && a % 3 == 0)
                System.out.print("*");
            if (b != 0 && b % 3 == 0)
                System.out.print("*");
            System.out.println();
        }
    }

    private static void game369() {
        for (int i = 0; i < 100; i++) {
            int num = i;
            int digit = 0;
            System.out.printf("%02d", num);
            while (num > 0) {
                digit = num % 10;
                if (digit != 0 && digit % 3 == 0) System.out.printf("*");
                num /= 10;
            }
            System.out.println();
        }
    }


    private static void printCheckLeapYear() {
        int i = 1700;
        if (checkLeapYear(i))
            System.out.println(i + "o");
        else
            System.out.println(i + "x");
    }

    public static boolean checkLeapYear(int year) {
        return (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0));
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    public static String is369(int cnt) {
        int a = cnt / 10;
        int b = cnt % 10;
        String str = (b != 0 && b % 3 == 0) ? "*" : ""; //일의 자리만 체크
        if (a == 0) //끝나면
            return str;

        return str + is369(a);
    }
}
