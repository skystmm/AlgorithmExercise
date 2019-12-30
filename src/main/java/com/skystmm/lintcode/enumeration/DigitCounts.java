package com.skystmm.lintcode.enumeration;

/**
 * 3. Digit Counts
 * @author: skystmm
 * @date: 2019/12/30 11:40
 */
public class DigitCounts {

    /**
     * AC time:O(n*m）space O(1)
     * @param k
     * @param n
     * @return
     */
    public int digitCounts(int k, int n) {
        if(k > n) return 0;

        int count = 0;
        if(k == 0){
           count = 1;
        }
        int i =0;
        while(i<=n){
            int cur = i;
            while(cur > 0){
                int c = cur%10;
                if(c==k){
                    count++;
                }
                cur /=10;
            }
            i++;
        }

        return  count;
    }


}
