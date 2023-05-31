package com.example.tutoopjdbc;

import java.util.ArrayList;
import java.util.List;

public class CMath {


    public static boolean isPrime(int num) {
        return (factorsOf(num).size() == 1);
    }

    public static boolean isPerpectionNumber(int num) {

        List<Integer> numbers = factorsOf(num);
        return (num == numbers.stream().mapToInt(Integer::intValue).sum());
    }

    private static List<Integer> factorsOf (int num) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    public static String factors(int num) {
        return factorsOf(num).toString();
    }
}
