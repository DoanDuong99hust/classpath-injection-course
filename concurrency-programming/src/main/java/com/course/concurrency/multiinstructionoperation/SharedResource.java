package com.course.concurrency.multiinstructionoperation;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {

    private int age = 0;
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int printAge() throws InterruptedException {
        synchronized (this) {
            System.out.println("Age=" + age + "locked");
            Thread.sleep(10000);
            return getAge();
        }
    }

    public void printV2() throws InterruptedException {
        synchronized (lock1) {
            reentrantReadWriteLock.readLock();
            try {
                System.out.println("Age=" + age);
                Thread.sleep(10000);
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        }
    }

    public void updateValue() throws InterruptedException {
        synchronized (lock2) {
            reentrantReadWriteLock.writeLock().lock();
            try {
                age = 10;
                System.out.println("Write age=" + age);
                Thread.sleep(10000);
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
        }
    }

    public void tryLockUpdate() throws InterruptedException {
//        while (true) {
            if (reentrantLock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread() + " Lock acquired");
                    Thread.sleep(5000);
                } finally {
                    reentrantLock.unlock();
                }
            }
            System.out.println(Thread.currentThread() + " Lock exhausted");
//        }
    }

    public void synchronizeUpdate() throws InterruptedException {
        while (true) {
            synchronized (this) {
                System.out.println("Lock acquired");
                Thread.sleep(10000);
            }
            System.out.println("Lock exhausted");
        }
    }
}

class CustomSynchronizedRunnable implements Runnable {

    SharedResource sharedResource;

    public CustomSynchronizedRunnable(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            sharedResource.printAge();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class CustomUnlockRunnable implements Runnable {
    SharedResource sharedResource;
    public CustomUnlockRunnable(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }


    @Override
    public void run() {
        try {
            sharedResource.printV2();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class CustomWriteRunnable implements Runnable {
    SharedResource sharedResource;
    public CustomWriteRunnable(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            sharedResource.updateValue();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class CustomTryLockUpdate implements Runnable {

    SharedResource sharedResource;

    public CustomTryLockUpdate(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            sharedResource.tryLockUpdate();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class CustomSynchronizedLock implements Runnable {

    SharedResource sharedResource;

    public CustomSynchronizedLock(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            sharedResource.synchronizeUpdate();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}