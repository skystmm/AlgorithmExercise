package com.skystmm.lintcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 9. Fizz Buzz
 * @author: skystmm
 * @date: 2020/1/2 14:25
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> res = new ArrayList<>(n);
        int i = 1;
        while(i <= n){
            if(i % 3 == 0 && i % 5 ==0){
                res.add("fizz buzz");
            }else if(i % 3 == 0){
                res.add("fizz");
            }else if(i % 5 == 0){
                res.add("buzz");
            }else{
                res.add(i +"");
            }
            i++;
        }

        return  res;
    }
}
