package com.algorithm.stack;

/**
 * @author Ernest Chen
 * @date 2/14/21.
 */
public class BackspaceCompare {
    /**
     * 时间复杂度:O(N + M）
     * 空间复杂度:O(N + M)
     * @param S 待比较字符串S
     * @param T 待比较字符串T
     * @return true/false
     */
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    /**
     * @param str 待构建的字符串
     * @return
     */
    private String build(String str) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '#') {
                bf.append(str.charAt(i));
            }else {
                if (bf.length() > 0) {
                    bf.deleteCharAt(bf.length() - 1);
                }
            }
        }
        return bf.toString();
    }
}
