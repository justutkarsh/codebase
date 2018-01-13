package companies.hortonworks;

import java.util.concurrent.Semaphore;

/**
 * Created by utkarsh on 18-10-2016.
 */
public class PingPongServer {

    public static void main(String[] args) {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        try {
            s2.acquire();

            Thread t1 = new Thread(new PingServer(s1, s2));
            Thread t2 = new Thread(new PongServer(s1, s2));

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    static class PingServer implements Runnable {

        Semaphore s1;
        Semaphore s2;

        public PingServer(Semaphore s1, Semaphore s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public void run() {
            while (true) {
                try {
                    s1.acquire();
                    System.out.println("PING");
                    s2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class PongServer
            implements Runnable
    {
        Semaphore s1, s2;

        public PongServer(Semaphore s1, Semaphore s2) {

            this.s1 = s1;
            this.s2 = s2;
        }

        public void run() {
            while (true) {
                try {
                    s2.acquire();
                    System.out.println("PONG");
                    s1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}

