package com.concurrent.test;

import java.util.concurrent.Semaphore;

/*
 Java 并发库 的Semaphore 可以很轻松完成信号量控制，Semaphore可以控制某个资源可被同时访问的个数，
 acquire()获取一个许可，如果没有就等待，而release()释放一个许可。比如在Windows下可以设置共享文件的最大客户端访问个数。 
 Semaphore维护了当前访问的个数，提供同步机制，控制同时访问的个数。在数据结构中链表可以保存“无限”的节点，用Semaphore可以实现有限大小的链表。
 另外重入锁ReentrantLock也可以实现该功能，但实现上要复杂些
*/

public class Semaphore01 {

    public static void main(String args[]) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 10; i++) {
            TaskThread test = new TaskThread(semaphore);
            test.start();
        }
    }

    static class TaskThread extends Thread {

        public Semaphore semaphore;

        public TaskThread(Semaphore s) {
            this.semaphore = s;
        }

        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " 获取到许可");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }

    }
}
