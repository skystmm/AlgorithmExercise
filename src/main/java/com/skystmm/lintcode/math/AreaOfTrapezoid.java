package com.skystmm.lintcode.math;

/**
 * 1776. Area Of Trapezoid
 * @author: skystmm
 * @date: 2020/1/17 10:43
 */
public class AreaOfTrapezoid {
    /**
     * AC
     * @param a
     * @param b
     * @param h
     * @return
     */
    public double solution(int a, int b, int h) {
        // Write your code here
        double res = (a + b) * h /2d;
        return res;
    }
}
