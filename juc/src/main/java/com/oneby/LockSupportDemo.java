package com.oneby;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockSupportDemo
 * @Description TODO
 * @Author Oneby
 * @Date 2020/12/27 14:25
 * @Version 1.0
 */
public class LockSupportDemo {

    public static void main(String[] args) {
        lockSupportParkUnpark();
    }

    static Object objectLock = new Object();

    private static void synchronizedWaitNotify() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
                try {
                    objectLock.wait(); // 等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒");
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify(); // 唤醒
                System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
            }
        }, "B").start();
    }


    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    private static void lockAwaitSignal() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "------come in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒");
            } finally {
                lock.unlock();
            }
        }, "A").start();


        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

    private static void lockSupportParkUnpark() {
        Thread a = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "------come in" + System.currentTimeMillis());
            LockSupport.park();
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "------被唤醒" + System.currentTimeMillis());
        }, "A");
        a.start();

        new Thread(() -> {
            LockSupport.unpark(a);
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "\t" + "------通知");
        }, "B").start();
    }
}


