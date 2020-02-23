package com.algorithm.offer;

/**
 * create by Ernest on 2020/2/23.
 */
public class ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        int spaceNum = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }

        int newLen = len + spaceNum * 2;
        int oldIndex = len - 1, newIndex = newLen - 1;

        str.setLength(newLen);

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


    public static String replaceBlank(StringBuffer sb){
        for (int i = 0; i < sb.length(); i++) {
            char ch1 = sb.charAt(i);
            if(ch1 == ' '){
                sb.replace(i, i+1, "%20");
            }
        }
        return sb.toString();
    }

    public static String replaceBlank2(String str){
        String str1 = str.replaceAll(" ", "%20");
        return str1;
    }

    public static String reverseStr(String str, char[] s) {
        String ssr = new StringBuffer(String.valueOf(s)).reverse().toString();
        ssr.toCharArray();
        return new StringBuffer(str).reverse().toString();
    }

    public void reverseString(char[] s) {
        int l = 0, h = s.length - 1;
        while(l < h) {
            char t = s[l];
            s[l++] = s[h];
            s[h--] = t;
        }
    }
}
