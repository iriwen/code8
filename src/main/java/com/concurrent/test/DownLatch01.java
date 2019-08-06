package com.concurrent.test;

import java.util.concurrent.CountDownLatch;

public class DownLatch01 {

    public CountDownLatch theLatch ;

    public DownLatch01(CountDownLatch downLatch) {
        this.theLatch = downLatch;
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);

        DownLatch01 inst = new DownLatch01(latch);

        Runnable task = () -> {
            try {
                inst.service();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {

            }
        };
        for (int i = 0; i < 5; i++) {
            Thread t  = new Thread(task);
            t.start();
        }
        latch.await();
        System.out.println("main thread : "+ Thread.currentThread().getName() );
    }

    public  void service() throws Exception{
        Thread.sleep(6000);
        System.out.println(Thread.currentThread().getName()+"-------------");
        theLatch.countDown();
    }
}
