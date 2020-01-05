package com.skystmm.lintcode.recursion;

import com.skystmm.common.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Flatten List
 * @author: skystmm
 * @date: 2020/1/5 23:08
 */
public class FlattenList {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList();
        parse(result,nestedList);
        return result;
    }


    private void parse(List<Integer> result,List<NestedInteger> nestedList){
        for(NestedInteger nestedInteger :nestedList){
            if(nestedInteger.isInteger()){
                result.add(nestedInteger.getInteger());
            }else{
                parse(result,nestedInteger.getList());
            }
        }
    }
}
