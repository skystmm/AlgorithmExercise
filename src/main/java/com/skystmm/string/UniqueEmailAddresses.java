package com.skystmm.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 * Created by sky on 2019/1/20
 */
public class UniqueEmailAddresses {
    /**
     * AC time : 54ms (题目理解错误)
     * @param emails
     * @return
     */
    public int solutionV1(String[] emails) {
        Set<String> mailSet = new HashSet<>();
        for(String cur : emails){
            String[] tmp = cur.split("@");
            String prefix = tmp[0].split("\\+")[0].replaceAll("\\.","");
            mailSet.add(prefix + tmp[1]);
        }
        return mailSet.size();
    }

    /**
     * AC  O(n) time :14 ms
     * @param emails
     * @return
     */
    public int solutionV2(String[] emails) {
        Set<String> mailSet = new HashSet<>();
        for(String cur : emails){
            mailSet.add(cur.substring(cur.indexOf("@")));
        }
        return mailSet.size();
    }
}
