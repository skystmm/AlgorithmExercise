package com.skystmm.array;

/**
 * 849. Maximize Distance to Closest Person
 * @author: skystmm
 * @date: 2019/1/1 20:46
 */
public class MaxDistToClosest {
    /**
     * OAC
     * @param seats
     * @return
     */
    public int solution(int[] seats) {
        int N = seats.length;
        int prev = -1, future = 0;
        int ans = 0;

        for (int i = 0; i < N; ++i) {
            if (seats[i] == 1) {
                prev = i;
            } else {
                while (future < N && seats[future] == 0 || future < i)
                    future++;

                int left = prev == -1 ? N : i - prev;
                int right = future == N ? N : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }

        return ans;


    }



    public static void main(String[] args) {
        System.out.println(new MaxDistToClosest().solution(new int[]{0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,1}));
    }
}
