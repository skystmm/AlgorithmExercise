package com.skystmm.leetcode.bit;

/**
 * 476. Number Complement
 * @author: skystmm
 * @date: 2019/12/25 15:20
 */
public class FindComplement {
    /**
     * AC time:O(num.bitlength) space:O(num.bitlength)
     * @param num
     * @return
     */
    public int solution(int num) {
        String s = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int  i =0 ; i< s.length(); i++){
           if(s.charAt(i) == '1'  && !flag){
              continue;
           }
           flag = true;
           sb.append(s.charAt(i) == '0'?1:0);
        }
        if(sb.length() == 0) return  0;
        return Integer.valueOf(sb.toString(),2);
    }


    public int solutionV2(int num){
        int res = 0;
        int m = 1;
        while (num != 0) {
            if ((num & 1) == 0) {
                res += m;
            }
            m = m << 1;
            num = num >> 1;
        }
        return res;
    }
}
