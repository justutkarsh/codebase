package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by utkarsh on 28-08-2016.
 */
/*
 Synchoronize three threads using three semaphores;
*/

public class SynchronizeThreadsSemaphore
 {
    class ListReader implements Runnable {

        List<Character> charList;
        Semaphore acquire;
        Semaphore release;

        public ListReader(List<Character> charList, Semaphore acquire, Semaphore release) {
            this.charList = charList;
            this.acquire = acquire;
            this.release = release;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < charList.size(); i++) {
                    acquire.acquire();
                    System.out.println(charList.get(i));
                    release.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startSynchronizing() {
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        Semaphore s3 = new Semaphore(1);
        try {
            s2.acquire();
            s3.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Character> l1 = Arrays.asList('a', 'a', 'a', 'a', 'a', 'a');
        List<Character> l2 = Arrays.asList('b', 'b', 'b', 'b', 'b', 'b');
        List<Character> l3 = Arrays.asList('c', 'c', 'c', 'c', 'c', 'c');

        Thread t1 = new Thread(new ListReader(l1, s1, s2));
        Thread t2 = new Thread(new ListReader(l2, s2, s3));
        Thread t3 = new Thread(new ListReader(l3, s3, s1));

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SynchronizeThreadsSemaphore synchronizeThreadsSemaphore = new SynchronizeThreadsSemaphore();
        synchronizeThreadsSemaphore.startSynchronizing();
    }


}
