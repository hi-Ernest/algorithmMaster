package com.algorithm.leetcode.大数相加;

/**
 * @author Ernest Chen
 * @date 2/22/21.
 */
public class BigNums {

    public static String addLargeNums(String num1, String num2) {
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        //"1111111" + "89898989"
        //从后往前依次相加 有进位则记录
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int len = Math.min(num1.length(), num2.length());
        int currNum = 0;
        for (int i = len - 1; i >= 0; i--) {
            currNum = num1.charAt(i) - '0' + num2.charAt(i) - '0' + carry;
            carry = currNum / 10;
            sb.append(currNum % 10);
        }
        if (num1.length() < num2.length()) {
            num1 = num2;
        }
        for (int j = num1.length() - len - 1; j >= 0; j--) {
            currNum = num1.charAt(j) - '0' + carry;
            carry = currNum / 10;
            sb.append(currNum % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addLargeNums("111111", "8989898989"));
    }
}
