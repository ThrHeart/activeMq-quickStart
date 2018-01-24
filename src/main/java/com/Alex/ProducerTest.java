package com.Alex;

/**
 * 生产者测试
 *
 * @author xupan
 * @create 2018/1/23
 * @since 1.0.0
 */
public class ProducerTest {
    public static void main(String[] args){
        final Producer producer = new Producer();
        producer.init();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        startThread(producer);
        //Thread 2
        startThread(producer);
    }

    private static void startThread(Producer producer) {
        new Thread(() -> {
            while(true){
                try {
                    producer.sendMessage("queueName");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
