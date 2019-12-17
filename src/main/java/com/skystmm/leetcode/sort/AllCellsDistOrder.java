package com.skystmm.leetcode.sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 1030. Matrix Cells in Distance Order
 *
 * @author: skystmm
 * @date: 2019/12/17 14:59
 */
public class AllCellsDistOrder {

    /**
     * BFS
     * AC time:O(R*C) space:O(R*C)
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> start = new ArrayList<>(2);
        start.add(r0);
        start.add(c0);
        res.add(start);
        HashSet<String> traversed = new HashSet<>();
        traversed.add(r0 + "-" + c0);
        Queue<List<Integer>> traversal = new ArrayDeque<>();
        traversal.add(start);
        while (!traversal.isEmpty()) {
            List<Integer> cur = traversal.poll();
            int rc = cur.get(0);
            int cc = cur.get(1);
            if (rc - 1 > -1) {
                checkOrAdd(rc - 1 ,cc, traversed, res,traversal);

            }
            if (rc + 1 < R) {
                checkOrAdd(rc + 1 ,cc, traversed, res,traversal);
            }

            if (cc - 1 > -1) {
                checkOrAdd(rc ,cc-1, traversed, res,traversal);
            }
            if (cc + 1 < C) {
                checkOrAdd(rc ,cc+1, traversed, res,traversal);
            }
        }

        int[][] result = new int[res.size()][];
        for(int i =0;i<res.size();i++){
            int[] a = new int[]{res.get(i).get(0),res.get(i).get(1)};
            result[i] = a;
        }
        return result;
    }

    private void checkOrAdd(int r,int c,Set<String> traversed,List<List<Integer>> res,Queue<List<Integer>> traversal){
        if (!traversed.contains(r + "-" + c)) {
            traversed.add(r + "-" + c);
            List<Integer> tmp = new ArrayList<>(2);
            tmp.add(r);
            tmp.add(c);
            res.add(tmp);
            traversal.add(tmp);
        }
    }
}
