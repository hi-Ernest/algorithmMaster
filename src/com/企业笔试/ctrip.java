//package com.qy;
//
//import java.util.*;
///**
// * create by Ernest on 2020/3/31.
// */
//public class ctrip {
//
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        int n = scanner.nextInt();
////        scanner.nextLine();
////        int time = scanner.nextInt();
////        scanner.nextLine();
////        int[] ids = new int[n];
////        int[] startTimes = new int[n];
////        int[] endTimes = new int[n];
////
////        for (int i = 0; i < n; i++) {
////            String[] inputs = scanner.nextLine().split(" ");
////            ids[i] = Integer.parseInt(inputs[0]);
////            startTimes[i] = Integer.parseInt(inputs[1]);
////            endTimes[i] = Integer.parseInt(inputs[2]);
////        }
////        printAllowRules(n, ids, startTimes, endTimes, time);
////    }
//
//    public static void printAllowRules(int n, int[] ids, int[] startTimes, int[] endTimes, int time) {
//        List<Integer> res = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if (time >= startTimes[i] && time <= endTimes[i]) {
//                res.add(ids[i]);
//            }
//        }
//
//        if (res.size() == 0) {
//            System.out.println("null");
//        }else {
//            Integer[] result = res.toArray(new Integer[res.size()]);
//            Arrays.sort(result);
//            for (int item : result) {
//                System.out.println(item);
//            }
//        }
//    }
//}
