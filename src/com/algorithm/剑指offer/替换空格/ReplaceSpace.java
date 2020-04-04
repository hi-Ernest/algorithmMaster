package com.algorithm.剑指offer.替换空格;

/**
 * create by Ernest on 2020/2/23.
 *
 * ex: 将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {

    /**
     * 自己拆分操作
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        int len = str.length();
        //先记录一共的空格数量
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }

        //扩容
        int newLen = len + spaceNum * 2;
        str.setLength(newLen);

        int oldIndex = len - 1, newIndex = newLen - 1;

        while (oldIndex > 0 && newIndex > oldIndex) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            }else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }

            oldIndex--;
        }

        return str.toString();
    }


    /**
     * 使用库函数直接 空格 -> "%20"
     * @param sb
     * @return
     */
    public static String replaceBlank(StringBuffer sb){
        for (int i = 0; i < sb.length(); i++) {
            char ch1 = sb.charAt(i);
            if(ch1 == ' '){
                sb.replace(i, i+1, "%20");
            }
        }
        return sb.toString();
    }

    /**
     * 另外一个库函数
     * @param str
     * @return
     */
    public static String replaceBlank2(String str){
        String str1 = str.replaceAll(" ", "%20");
        return str1;
    }

    /**
     * 反转字符串
     * @param str
     * @return
     */
    public static String reverseStr(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * String -> char[] -> 反转
     * @param s
     */
    public void reverseString(char[] s) {
        int l = 0, h = s.length - 1;
        while(l < h) {
            char t = s[l];
            s[l++] = s[h];
            s[h--] = t;
        }
    }
}
