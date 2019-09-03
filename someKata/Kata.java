package com.company;

import java.util.ArrayList;
import java.util.List;

public class Kata {

    public static List<Long> sumDigPow(long a, long b) {

        List<Long> list = new ArrayList<>();

        for (long i = a; i <= b; i++) {
            String str = String.valueOf(i);
            long lg = 0;
            for (int j = 0; j < str.length(); j++) {
                lg += Math.pow(new Long(str.substring(j, j+1)), j+1);
                if(lg == i) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(sumDigPow(1, 100));
    }
}
