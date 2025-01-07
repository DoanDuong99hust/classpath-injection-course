package com.course.concurrency.multiinstructionoperation;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteLock {

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        SharedResource sharedResource = new SharedResource();
        testTryLockSynchronized(new CustomTryLockUpdate(sharedResource));
//        final long duration = System.nanoTime() - startTime;
//        System.out.println(duration);
    }

    private static void testReadWriteLock() {
        List<Thread> reentrantLock = new ArrayList<>();
        SharedResource sharedResource = new SharedResource();

        for (int i = 0; i < 5; i++) {
            reentrantLock.add(new Thread(new CustomUnlockRunnable(sharedResource)));
        }

        for (int i = 0; i < 2; i++) {
            reentrantLock.add(new Thread(new CustomWriteRunnable(sharedResource)));
        }

        for (int i = 0; i < 3; i++) {
            reentrantLock.add(new Thread(new CustomUnlockRunnable(sharedResource)));
        }

//        for (Thread thread : reentrantLock) {
//            thread.start();
//        }
    }

    private static void testTryLockSynchronized(Runnable runnable) {
        List<Thread> tryLock = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            tryLock.add(new Thread(runnable));
        }
        System.out.println(tryLock.size());
        for (Thread thread : tryLock) {
            thread.start();
        }
    }
}


