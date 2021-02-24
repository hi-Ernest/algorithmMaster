package com.企业笔试.网易互娱;

import java.util.*;

/**
 * create by Ernest on 2020/4/11.
 */
public class Main {

    static List<List<Integer>> res = new LinkedList<>();

    public void getResult(List<Integer> peopes, List<Integer>tasks, LinkedList<Integer> sub, int n) {

        if (sub.size() == n) {
            res.add(new LinkedList(sub));
            return;
        }

        for (int i = 0; i < peopes.size(); i++) {
            for (int j = 0; j < tasks.size(); j++) {
                if (sub.contains(tasks.get(j))) {
                    continue;
                }
                if (peopes.get(i) > tasks.get(j)) {
                    sub.add(tasks.get(j));
                    getResult(peopes, tasks, sub, n);
                    sub.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> peoples = new LinkedList<>();
        List<Integer> tasks = new LinkedList<>();
        LinkedList<Integer> sub = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            peoples.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            tasks.add(scanner.nextInt());
        }

        System.out.println(peoples);
        System.out.println(tasks);
        new Main().getResult(peoples, tasks, sub, n);
        System.out.println(res.size());
    }
}

