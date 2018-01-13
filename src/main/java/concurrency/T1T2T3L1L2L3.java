package concurrency;

import java.util.Iterator;

/**
 * Created by utkarsh on 11-08-2016.
 * Three Lists Three Threads T1 prints L1-1 then T2 prints L2-1 then T3 prints L3-1
 * T1 then   l1-2 then T2  L2-2            T3 L3-2
 */
public class T1T2T3L1L2L3 {

    static class Counter {

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Counter(int count) {
            this.count = count;
        }

        public volatile int count;
    }

    static class Threadsync implements Runnable {

        Object lock;
        int id;
        volatile Counter globalcounter;
        int[] list;

        public Threadsync(Object lock, int id, Counter globalcounter, int[] list) {

            this.lock = lock;
            this.id = id;
            this.list = list;
            this.globalcounter = globalcounter;
        }

        public int[] getList() {
            return list;
        }

        public void setList(int[] list) {
            this.list = list;
        }

        public Object getLock() {
            return lock;
        }

        public void setLock(Object lock) {
            this.lock = lock;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        @Override
        public void run() {
            for (int t : list) {
                synchronized (lock) {
                    while (globalcounter.count != id) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.print(t + ",");
                    globalcounter.count = (globalcounter.count + 1) % 3;
                    lock.notifyAll();
                }
            }
        }

    }


    public static void main(String[] args) {

        Object lock = new Object();
        Counter count = new Counter(0);

        int[] list1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] list2 = new int[]{11, 12, 13, 14, 15, 16, 17};
        int[] list3 = new int[]{21, 32, 33, 34, 35, 36, 37};

        Runnable r1 = new Threadsync(lock, 0, count, list1);
        System.out.println(count.count);
        Runnable r2 = new Threadsync(lock, 1, count, list2);
        System.out.println(count.count);

        Runnable r3 = new Threadsync(lock, 2, count, list3);
        System.out.println(count.count);


        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();


    }


}



