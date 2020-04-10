package com.jk.javase.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.FutureTask;

/**
 * @author jk
 * @Date: 2020/4/7
 */
@Slf4j(topic = "c.test1")
public class Test1 {
    static int[] ARRAY = new int[100_000_00];
    static {
        Arrays.fill(ARRAY , 1);
    }

    public static void main(String[] args) throws Exception {


//        Thread thread1 = new Thread(() -> {
//            log.info("线程测试");
//        }, "thread1");
//        thread1.start();
        log.info("线程性能测试");

        long startTime_thread_1 = System.currentTimeMillis();    //获取开始时间
        int result_thread_1 = thread_1();//测试的代码段
        long endTime_thread_1 = System.currentTimeMillis();    //获取结束时间
        log.info("运算结果为"+ result_thread_1 + "----------------------"+ "单线程耗时约"+ (endTime_thread_1 - startTime_thread_1) + "ms");

        long startTime_thread_n = System.currentTimeMillis();    //获取开始时间
        int result_thread_n = thread_n();
        long endTime_thread_n = System.currentTimeMillis();    //获取结束时间
        log.info("运算结果为"+ result_thread_n + "----------------------"+ "多线程耗时约"+ (endTime_thread_n - startTime_thread_n) + "ms");

    }


    public static int thread_1() throws Exception{

        int [] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0;i < 100_000_00;i++){
                sum += array[0+i];
            }
            return sum;
        });
        new Thread(t1,"one").start();
        return t1.get();

    }


    public static int thread_n() throws Exception{
        int [] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0;i < 25_000_00;i++){
                sum += array[0+i];
            }
            return sum;
        });
        FutureTask<Integer> t2 = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0;i < 25_000_00;i++){
                sum += array[0+i];
            }
            return sum;
        });
        FutureTask<Integer> t3 = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0;i < 25_000_00;i++){
                sum += array[0+i];
            }
            return sum;
        });
        FutureTask<Integer> t4 = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 0;i < 25_000_00;i++){
                sum += array[0+i];
            }
            return sum;
        });
        new Thread(t1,"n -> t1").start();
        new Thread(t2,"n -> t2").start();
        new Thread(t3,"n -> t3").start();
        new Thread(t4,"n -> t4").start();
        return t1.get() + t2.get() + t3.get() + t4.get();


    }

}
