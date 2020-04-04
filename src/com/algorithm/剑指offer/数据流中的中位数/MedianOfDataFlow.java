package com.algorithm.剑指offer.数据流中的中位数;

import java.util.*;

/**
 * create by Ernest on 2020/2/26.
 *
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class MedianOfDataFlow {

    LinkedList<Integer> list = new LinkedList<>();

    public void Insert(Integer num) {
        if (list.size() == 0 || num < list.getFirst()) {
            list.addFirst(num);
        }else {
            boolean insertFlag = false;
            for (Integer emit : list) {
                if (num < emit) {
                    int index = list.indexOf(emit);
                    list.add(index, num);
                    insertFlag = true;
                    break;
                }
            }
            if (!insertFlag) {
                list.addLast(num);
            }
        }
        System.out.println(list);
    }

    public Double GetMedian() {
        if (list.size() == 0) {
            return null;
        }

        if (list.size() % 2 == 0) {
            int index = list.size() / 2;
            Double res = Double.valueOf(list.get(index) + list.get(index - 1));
            return res / 2;
        }else {
            return Double.valueOf(list.get((list.size() + 1) / 2 - 1));
        }
    }

    public static void main(String[] args) {
        MedianOfDataFlow modf = new MedianOfDataFlow();
//        modf.list.addAll(Arrays.asList(5, 2, 3));

        modf.Insert(5);
        modf.Insert(2);
        modf.Insert(3);

        System.out.println(modf.GetMedian());
    }
}
