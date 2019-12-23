package com.algorithm;
import java.util.*;

public class EffectiveBracktets {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateOneByOne("", res, n, n);
        return res;
    }

    private void generateOneByOne(String sublist, List<String> res, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sublist);
            return;
        }

        if (left > 0) {
            generateOneByOne(sublist + "(", res, left - 1, right);
        }
        if (right > left) {
            generateOneByOne(sublist + ")", res, left, right - 1);
        }
    }


}
