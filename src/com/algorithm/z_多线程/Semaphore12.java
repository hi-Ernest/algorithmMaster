package com.algorithm.z_多线程;

import java.util.concurrent.Semaphore;

/**
 * @author Ernest Chen
 * @date 3/6/21 8:54 PM.
 */
public class Semaphore12 {

    static int N = 8; //工人数
    static Semaphore semaphore = new Semaphore(5); //机器数目

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }
    }
}
