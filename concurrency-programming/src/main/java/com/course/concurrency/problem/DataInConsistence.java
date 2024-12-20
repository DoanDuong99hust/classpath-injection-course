package com.course.concurrency.problem;

import java.util.*;

public class DataInConsistence {

    private Map<Integer, Integer> testMap = new HashMap<>();
    private long employeeSalary;
    private long bossSalary;
    private List<Integer> naturalList = new ArrayList<>();

    public DataInConsistence() {
        for (int i = 0; i < 1000; i++) {
            testMap.put(i, i);
        }
//        employeeSalary = 0;
//        bossSalary = 0;
//        for (int i = 0; i < 100000; i++) {
//            naturalList.add(i);
//        }
    }

    public static void main(String[] args) {
        checkInConsistence();
//        checkSalary();
//        checkSumArray();
    }

    public static void checkInConsistence() {
        System.out.println(Thread.currentThread().getName());
        DataInConsistence dataInConsistence = new DataInConsistence();

//        Thread readThread = new Thread(() -> {
//        dataInConsistence.testMap.entrySet().forEach((entry) -> {
//            try {
//                Thread.sleep(5);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(Thread.currentThread().getName() + "-" + entry.getKey() + " : " + entry.getValue());
//        });
//
////            for (Map.Entry<Integer, Integer> entry : dataInConsistence.testMap.entrySet()) {
////                System.out.println(Thread.currentThread().getName() + "-" + entry.getKey() + " : " + entry.getValue());
//////                if (!Objects.equals(entry.getValue(), entry.getKey())) {
//////                    throw new RuntimeException("Data inconsistence key=%d; value=%d".formatted(entry.getKey(), entry.getValue()));
//////                }
////            }
//        });

//        Thread writeThread = new Thread(
//                () -> {
////            dataInConsistence.testMap.entrySet().stream().forEach((entry) -> {
////                if (entry.getKey() == 50) {
////                try {
////                    Thread.sleep(300);
////                } catch (InterruptedException e) {
////                    throw new RuntimeException(e);
////                }
////                System.out.println("edting running" + dataInConsistence.testMap.get(9999));
////                while (true) {
////                dataInConsistence.testMap.put(200, -1000);
////                }
//
////                    try {
////                        Thread.sleep(500);
////                    } catch (InterruptedException e) {
////                        throw new RuntimeException(e);
////                    }
////                }
////            });
//                    Map<Integer, Integer> map = dataInConsistence.getTestMap();
//            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                System.out.println(Thread.currentThread().getName() + "-" + entry.getKey() + " : " + entry.getValue());
////                if (entry.getKey() == 20) {
//                map.put(20, -20);
//                map.put(5, -50);
////                }
//            }
//        });
//        readThread.start();
        Thread thread = new Thread(){
            @Override
            public void run(){
                Map<Integer, Integer> map = dataInConsistence.getTestMap();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    map.put(20, -20);
                    map.put(5, -50);
                }
            }
        };

        thread.start();
    }












    private static void checkSalary() {
        DataInConsistence dataInConsistence = new DataInConsistence();
        Thread check = new Thread(() -> {
            while (true) {
                System.out.println("employee salary = %d; boss salary = %d".formatted(dataInConsistence.employeeSalary, dataInConsistence.bossSalary));
                if (dataInConsistence.employeeSalary > dataInConsistence.bossSalary) {
                    throw new RuntimeException("Impossible employee salary = %d; boss salary = %d"
                            .formatted(dataInConsistence.employeeSalary, dataInConsistence.bossSalary));
                }
            }
        });

        Thread update = new Thread(() -> {
            while (true) {
                dataInConsistence.bossSalary++;
                dataInConsistence.employeeSalary++;
            }
        });
        update.start();
        check.start();
    }

    private static void checkSumArray() {
        DataInConsistence dataInConsistence = new DataInConsistence();

        Thread sum1 = new Thread(() -> System.out.println(Thread.currentThread().getName() + "result=" + sumArray(dataInConsistence.naturalList)));

        Thread sum2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + "result=" + sumArray(dataInConsistence.naturalList)));

        Thread sum3 = new Thread(() -> System.out.println(Thread.currentThread().getName() + "result=" + sumArray(dataInConsistence.naturalList)));

        Thread sum4 = new Thread(() -> System.out.println(Thread.currentThread().getName() + "result=" + sumArray(dataInConsistence.naturalList)));

        sum1.start();
        sum2.start();
        sum3.start();
        sum4.start();
    }

    private static Integer sumArray(List<Integer> list) {
//        return list.stream().mapToInt(Integer::intValue).sum();
        Integer sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public Map<Integer, Integer> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<Integer, Integer> testMap) {
        this.testMap = testMap;
    }
}
