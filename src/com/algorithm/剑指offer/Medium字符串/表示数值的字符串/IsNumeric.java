package com.algorithm.剑指offer.Medium字符串.表示数值的字符串;

/**
 * @author Ernest Chen
 * @date 2020/7/11.
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 */
public class IsNumeric {

//    bool isNumeric(char* str) {
//        // 标记符号、小数点、e是否出现过
//        bool sign = false, decimal = false, hasE = false;
//        for (int i = 0; i < strlen(str); i++) {
//            if (str[i] == 'e' || str[i] == 'E') {
//                if (i == strlen(str)-1) return false; // e后面一定要接数字
//                if (hasE) return false;  // 不能同时存在两个e
//                hasE = true;
//            } else if (str[i] == '+' || str[i] == '-') {
//                // 第二次出现+-符号，则必须紧接在e之后
//                if (sign && str[i-1] != 'e' && str[i-1] != 'E') return false;
//                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
//                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') return false;
//                sign = true;
//            } else if (str[i] == '.') {
//                // e后面不能接小数点，小数点不能出现两次
//                if (hasE || decimal) return false;
//                decimal = true;
//            } else if (str[i] < '0' || str[i] > '9') // 不合法字符
//                return false;
//        }
//        return true;
//    }

    boolean isNumeric(char[] str) {
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                //e 后面必须接数字
                if (i == str.length - 1) {
                    return false;
                }
                //不能同时存在两个e
                if (hasE) {
                    return false;
                }
                hasE = true;
            }else if (str[i] == '+' || str[i] == '-') {
                //第二次出现'+'或者'-',必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                //第一次出现'+'或者'-',且不是在字符串开头,则必须紧接在e之后
                if (!sign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    return false;
                }
                //补充：只是符号
                if (i == str.length - 1) {
                    return false;
                }
                sign = true;
            }else if (str[i] == '.') {
                //e 后面不能有小数点,且小数点不能出现两次
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            }else if (str[i] < '0' || str[i] > '9'){ // 不合法字符
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsNumeric().isNumeric(new char[]{'+'}));;
    }

}
