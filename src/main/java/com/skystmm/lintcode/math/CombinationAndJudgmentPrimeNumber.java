package com.skystmm.lintcode.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1666. Combination and judgment prime number
 * @author: skystmm
 * @date: 2020/1/17 14:45
 */
public class CombinationAndJudgmentPrimeNumber {

    private List<List<Integer>> res;
    /**
     * OAC time space
     * @param a: the n numbers
     * @param k: the number of integers you can choose
     * @return: how many ways that the sum of the k integers is a prime number
     */
    public int getWays(int[] a, int k) {
        // Write your code here

        res = new ArrayList<List<Integer>>();
        if (a.length == 0 || k <= 0 || k > a.length)
            return 0;

        LinkedList<Integer> c = new LinkedList<Integer>();
        generateCombinations(a.length, k, 1, c);

        int ans = 0;
        for (List<Integer> list : res) {
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += a[list.get(j) - 1];
            }
            if (check(sum)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(int a) {
        if (a < 2) {
            return false;
        }
        boolean ean = true;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                ean = false;
                break;
            }
        }
        return ean;
    }

    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c) {

        if (c.size() == k) {
            res.add((List<Integer>) c.clone());
            return;
        }

        for (int i = start; i <= n - (k - c.size()) + 1; i++) {
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }
    }

}
