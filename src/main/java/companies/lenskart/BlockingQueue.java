package companies.lenskart;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by utkarsh on 13-09-2016.

two seperate conditions are maintained for maintained two different wait queues for optimization reasons

 if if is used of instead of while
 then race condition   A B C   B=producer A,C consumer

 A waiting at 0 capacity line 51
 C gets the lock first and gets last element produced by B

 since there is no while loop A will try to withdraw from empty list.

 */


public class BlockingQueue {
    private final static int CAPACITY = 1024;

    private Queue<Integer> q = new LinkedList<>();
    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void offer(Integer e) throws InterruptedException {
        if (e == null) throw new NullPointerException();
        lock.lock();
        try {
            while (q.size() == CAPACITY) {
                notFull.await();
            }
            q.offer(e);

            notEmpty.notifyAll();

        } finally {
            lock.unlock();
        }
    }


    public Integer poll() throws InterruptedException {
        lock.lock();
        try {
            while (q.size() == 0) {
                notEmpty.await();
            }
            notFull.notifyAll();
            return q.poll();

        } finally {
            lock.unlock();
        }
    }
}
