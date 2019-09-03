package com.company;

import java.math.BigDecimal;

public class Solution {
    public static String power(int n) {

        BigDecimal bd = BigDecimal.ZERO;

        for (int i = 1; i <= n; i++) {
            BigDecimal b = new BigDecimal(i);
            bd = bd.add(b.pow(i));
        }
        String str = bd.toString();
        if (str.length() > 10) {
            str = str.substring(str.length() - 10, str.length());
        }
        while (str.startsWith("0")) {
            str = str.substring(1);
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(power(10));
    }
}
