package com.Alex;

/**
 * 消费者测试
 *
 * @author xupan
 * @create 2018/1/23
 * @since 1.0.0
 */
public class ConsumerTest {

    public static void main(String[] args){
        final Consumer consumer = new Consumer();
        consumer.init();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startThread(consumer);
        startThread(consumer);
    }

    private static void startThread(Consumer consumer) {
        new Thread(() -> {
            while(true){
                try {
                    consumer.getMessage("queueName");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
