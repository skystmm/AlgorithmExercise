package com.skystmm.string;

/**
 * 657. Robot Return to Origin
 * @author: skystmm
 * @date: 2019/10/23 15:35
 */
public class JudgeCircle {
    /**
     * AC time : O(n),space : O(1)
     * @param moves
     * @return
     */
    public boolean solution(String moves) {
        int UDCount = 0;
        int LRCount = 0;
        for(char c : moves.toCharArray()){
            switch (c){
                case 'U':
                    UDCount ++;
                    break;
                case 'D':
                    UDCount--;
                    break;
                case 'L':
                    LRCount++;
                    break;
                case 'R':
                    LRCount--;
                    break;
            }
        }
        return UDCount ==0 && LRCount == 0;
    }
}
