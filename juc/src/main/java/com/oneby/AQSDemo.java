package com.oneby;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AQSDemo
 * @Description TODO
 * @Author Oneby
 * @Date 2021/1/21 11:08
 * @Version 1.0
 */
public class AQSDemo {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        // 带入一个银行办理业务的案例来模拟我们的AQS如何进行线程的管理和通知唤醒机制
        // 3个线程模拟3个来银行网点，受理窗口办理业务的顾客
        // A顾客就是第一个顾客，此时受理窗口没有任何人，A可以直接去办理
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("-----A thread come in");

                try {
                    TimeUnit.MINUTES.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlock();
            }
        }, "A").start();

        // 第二个顾客，第二个线程---》由于受理业务的窗口只有一个(只能一个线程持有锁)，此时B只能等待，
        // 进入候客区
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("-----B thread come in");
            } finally {
                lock.unlock();
            }
        }, "B").start();

        // 第三个顾客，第三个线程---》由于受理业务的窗口只有一个(只能一个线程持有锁)，此时C只能等待，
        // 进入候客区
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("-----C thread come in");
            } finally {
                lock.unlock();
            }
        }, "C").start();
    }
}
