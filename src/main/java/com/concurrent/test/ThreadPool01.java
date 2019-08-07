package com.concurrent.test;

import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool01 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() * 2,
                        0L, TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<Runnable>(Runtime.getRuntime().availableProcessors() * 4),
                        //线程工厂创建线程的方式，线程名字为前缀加数字依次叠加
                        new ThreadFactory() {
                            int count = 0;
                            @Override
                            public Thread newThread(Runnable r) {
                                Thread t = new Thread(r);
                                t.setName("NUC-Processor" + "-" + (count++));
                                t.setDaemon(true);
                                return t;
                            }
                        });

        for(int i = 0;i<16;i++){
            //线程池采用默认的拒绝策略，任务数超出即拒绝执行
            executor.submit(()->{
                //非阻塞向线程池中提交任务，继续向下执行
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+ " : " + LocalDateTime.now());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //会比线程池中的任务慢3s（5-3）执行
        Thread.currentThread().sleep(5000);
        System.out.println("main thread exited !" + LocalDateTime.now());
    }
}
