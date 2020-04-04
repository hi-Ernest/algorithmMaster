package com.企业笔试.ctrip;

/**
 * create by Ernest on 2020/4/1.
 */
public class Fib {
    int[] boths = {2, 4};

    public static void main(String[] args) {
        Fib fib = new Fib();
        for(int i = 1 ; i <= 5; i++){
//            System.out.println("第"+i+ "年后  : " + fib(i) +"头");
            fib.countCow(i);
        }

    }

    public static int fib(int n) {
       int[] dp = new int[n + 1];
       dp[0] = 2;
       dp[1] = 4;
       for (int i = 2; i <= n; i++) {
//           if ()
           dp[i] = dp[i-1] + dp[i-2];
       }
       return dp[n];
    }

    private int countCow(int year) {
        return (year == 2 || year == 4) ? year + 1 : countCow(year - 1) + countCow(year - 5);
    }
}
