package com.oneby;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReEnterLockDemo
 * @Description 可重入锁:可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样的锁就叫做可重入锁。
 * 在一个synchronized修饰的方法或代码块的内部调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的
 * @Author Oneby
 * @Date 2020/12/27 11:10
 * @Version 1.0
 */
public class ReEnterLockDemo {

    // synchronized 同步代码块可重入演示
    /*
    static Object objectLockA = new Object();

    public static void m1() {
        new Thread(() -> {
            synchronized (objectLockA) {
                System.out.println(Thread.currentThread().getName() + "\t" + "------外层调用");
                synchronized (objectLockA) {
                    System.out.println(Thread.currentThread().getName() + "\t" + "------中层调用");
                    synchronized (objectLockA) {
                        System.out.println(Thread.currentThread().getName() + "\t" + "------内层调用");
                    }
                }
            }
        }, "t1").start();

    }

    public static void main(String[] args) {
        m1();
    }
     */

    // synchronized 同步方法可重入演示
    /*
    public synchronized void m1() {
        System.out.println("=====外层");
        m2();
    }

    public synchronized void m2() {
        System.out.println("=====中层");
        m3();
    }

    public synchronized void m3() {
        System.out.println("=====内层");
    }


    public static void main(String[] args) {
        new ReEnterLockDemo().m1();
    }
     */

    // synchronized 关键字原理

    /*
    static Object lockObject = new Object();
    public static void m1() {
        synchronized (lockObject){
            System.out.println("I am Oneby");
        }
    }
     */
    // ReentrantLock 可重入演示
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("=======外层");
                lock.lock();
                try {
                    System.out.println("=======内层");
                } finally {
                    lock.unlock();
                }
            } finally {
                //实现加锁次数和释放次数不一样
                //由于加锁次数和释放次数不一样，第二个线程始终无法获取到锁，导致一直在等待。
                lock.unlock();    //正常情况，加锁几次就要解锁几次
            }
        }, "t1").start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("b thread----外层调用lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

}

