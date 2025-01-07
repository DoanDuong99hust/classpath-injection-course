package com.course.concurrency;

import com.course.concurrency.util.CustomRunnable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * Instruction
 * CPU -> Core
 * Interference
 * Race Condition
 *
 * Recall concept
 * về mối liên hệ giữa thứ tự execute instructions vs cpu
 * Blocking & Non-Blocking example
 * Out of Memory & Stack OverFlow difference
 * Heap & Stack, pass by reference & pass by value, parameter & argument
 * Shared Resource + At least one Thread modifies shared resource
 *
 * synchonized method, synchonized statement, Lock : Read check lock, Read write lock, ReEntrance lock
 * https://jenkov.com/tutorials/java-concurrency/creating-and-starting-threads.html#runnable-interface-implementation
 */

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new CustomRunnable());
        Thread thread2 = new Thread(new CustomRunnable());
        Thread thread3 = new Thread(new CustomRunnable());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}