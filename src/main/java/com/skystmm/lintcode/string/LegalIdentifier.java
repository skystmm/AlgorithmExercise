package com.skystmm.lintcode.string;

import java.util.regex.Pattern;

/**
 * @author: skystmm
 * @date: 2020/1/17 11:26
 */
public class LegalIdentifier {

    /**
     * AC use regex
     * @param str: The identifier need to be judged.
     * @return: Return if str is a legal identifier.
     */
    public boolean isLegalIdentifier(String str) {
        // Write your code here.
        Pattern pattern = Pattern.compile("^[a-z|_][a-z|0-9|_]*$");
        String tar = str.toLowerCase();
        return pattern.matcher(tar).find();
    }
}
