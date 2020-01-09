package zz.concurrency;

public class Teser{

    //extends Thread ==> implement Runnable
    static class PlayMusicThread_extends extends Thread {
        private int playTime = 10;

        public void run() {
            for (int i = 0; i < playTime; i++) {
                System.out.println("play music: " + i +" "+ super.getName());
            }
        }
    }

    static class PlayMusicThread_implements implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("play music: " + i +" "+ Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        //Main thread
        for (int i = 0; i < 10; i++) {
            System.out.println("play game: " + i);
            if (i == 2) {
                //create a play music thread
                PlayMusicThread_extends pte = new PlayMusicThread_extends();
                pte.start();

                PlayMusicThread_implements pti = new PlayMusicThread_implements();
                new Thread(pti, "name").start();
            }
        }
    }

}
