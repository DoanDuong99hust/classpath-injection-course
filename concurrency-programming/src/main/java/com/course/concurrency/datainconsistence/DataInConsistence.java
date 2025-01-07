package com.course.concurrency.datainconsistence;

import java.util.*;

public class DataInConsistence {

    private Map<Integer, Integer> testMap = new HashMap<>();
    private long employeeSalary;
    private long bossSalary;
    private List<Integer> naturalList = new ArrayList<>();

    public DataInConsistence() {
        for (int i = 0; i < 1000; i++) {
            testMap.put(i,i);
        }
        employeeSalary = 0;
        bossSalary = 0;
        for (int i = 0; i < 100000; i++) {
            naturalList.add(i);
        }
    }

    public static void main(String[] args) {
        checkInConsistence();
//        checkSalary();
//        checkSumArray();
    }

    public static void checkInConsistence() {
        DataInConsistence dataInConsistence = new DataInConsistence();
        Map<Integer, Integer> map = dataInConsistence.getTestMap();
        Thread editThread = new Thread(() -> {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() == 1000) {
                    map.put(50, -50);
                }
            }
        });

        Thread checkThread = new Thread(() -> {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (!Objects.equals(entry.getKey(), entry.getValue())) {
                    throw new RuntimeException("Data inconsistence");
                }
            }
        });

        checkThread.start();
        editThread.start();
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

    // todo: confirm the objective with Tung
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
