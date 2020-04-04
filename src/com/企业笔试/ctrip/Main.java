package com.企业笔试.ctrip;

/**
 * create by Ernest on 2020/4/1.
 */
import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int calcMinStaff(int[] startTimes, int[] endTimes) {
        if (startTimes.length == 0 || endTimes.length == 0) {
            return 0;
        }

        int res = 1;
        LinkedList<Integer> endTimeList = new LinkedList<>();
        endTimeList.add(endTimes[0]);
        boolean flag = false;
        for (int i = 1; i < startTimes.length; i++) {
            for (int j = 0; j < endTimeList.size(); j++) {
                flag = false;
                if (startTimes[i] < endTimeList.get(j)) {
                    flag = true;
                }else {
                    endTimeList.remove(j);
                }
            }
            if (flag) {
                res++;
            }
            endTimeList.add(endTimes[i]);
        }
        return res;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            String[] inputs = in.nextLine().split(",");
            startTimes[i] = Integer.parseInt(inputs[0]);
            endTimes[i] = Integer.parseInt(inputs[1]);
        }
        int res;

        res = calcMinStaff(startTimes, endTimes);
        System.out.println(String.valueOf(res));

    }
}
