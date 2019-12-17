package com.skystmm.leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: skystmm
 * @date: 2019/11/12 15:58
 */
public class FindSolution {

    public List<List<Integer>> solution(CustomFunction customfunction, int z) {
        List<List<Integer>> solutionList = new ArrayList<>();
        int x = 1, y = z;
        while(x <= z && y > 0) {
            if(customfunction.f(x, y) == z) {
                solutionList.add(Arrays.asList(x, y));
                x++;
                y--;
            } else if(customfunction.f(x, y) > z) {
                y--;
            } else {
                x++;
            }
        }
        return solutionList;
    }
}

class CustomFunction {
      // Returns f(x, y) for any given positive integers x and y.
             // Note that f(x, y) is increasing with respect to both x and y.
              // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
     public int f(int x, int y) {
        return 0;
     }
  };