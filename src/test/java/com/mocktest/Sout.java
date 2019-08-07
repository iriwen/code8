package com.mocktest;

public class Sout {

    public static void main(String[] args) {
        new Thread(() -> {
            for (; ; ) {
                System.out.println("Thread1 :" + Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            for (; ; ) {
                System.out.println("Thread2 :" + Thread.currentThread().getName());
            }
        }).start();

    }
}
