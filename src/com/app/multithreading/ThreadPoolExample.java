package com.app.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadJob extends Thread {
    String s;

    ThreadJob(String s) {
        this.s = s;
    }

    public void run() {
        try {
            System.out.println(s + " ...job Started By Thread" + Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(s + " ...job completed By Thread" + Thread.currentThread().getName());
        } catch (Exception e) {
        }
    }
}

class ThreadPoolExample {
    static ExecutorService s = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        ThreadJob[] jobs = { new ThreadJob("meanon"), new ThreadJob("harini"), new ThreadJob("karun"),
                new ThreadJob("diya"), new ThreadJob("varun"), new ThreadJob("riya"), new ThreadJob("sana"),
                new ThreadJob("harika"), new ThreadJob("linda") };
        for (ThreadJob j : jobs) {
            s.submit(j);
        }
        s.shutdown();
    }
}