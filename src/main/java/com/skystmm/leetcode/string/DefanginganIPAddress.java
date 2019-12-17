package com.skystmm.leetcode.string;

/**
 * 1108. Defanging an IP Address
 * @author: skystmm
 * @date: 2019/8/8
 */
public class DefanginganIPAddress {

    /**
     * use replaceAll
     * AC :2ms
     * @param address
     * @return
     */
    public String solution(String address) {
        return  address.replaceAll("\\.","[\\.]");
    }

    /**
     * AC :0 ms
     * @param address
     * @return
     */
    public String solution2(String address) {
       StringBuilder output = new StringBuilder();
       for(char c : address.toCharArray()){
           if (c == '.'){
               output.append("[.]");
           }else{
               output.append(c);
           }
       }
       return output.toString();
    }
}
