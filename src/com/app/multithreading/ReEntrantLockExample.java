package com.app.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class SayMessage {
    int availableSeats = 1;
    static ReentrantLock l = new ReentrantLock();

    public void bookTicket(String name, int number) {
        try {
            do {
                if (l.tryLock(2000, TimeUnit.MILLISECONDS)) {
                    System.out.println(name + " is got chance to booking the Seat number" + number);
                    Thread.sleep(8000);
                    l.unlock();
                    if (availableSeats > 0) {
                        System.out.println(name + " is booked the Seat number" + number);
                        availableSeats = availableSeats - 1;
                    } else {
                        System.out.println(name + " Sorry seats are not available!");
                    }
                    break;
                } else {
                    System.out.println(name + " is trying for booking ,seat number " + number);
                }
            } while (true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadDemo extends Thread {
    SayMessage t;
    int number;
    String name;

    ThreadDemo(SayMessage t, int number, String name) {
        this.t = t;
        this.number = number;
        this.name = name;
    }

    public void run() {
        t.bookTicket(name, number);
    }
}

public class ReEntrantLockExample {
    public static void main(String[] args) {
        SayMessage t = new SayMessage();
        ThreadDemo r1 = new ThreadDemo(t, 1, "Karun");
        ThreadDemo r2 = new ThreadDemo(t, 1, "Varun");
        r1.start();
        r2.start();
    }
}
