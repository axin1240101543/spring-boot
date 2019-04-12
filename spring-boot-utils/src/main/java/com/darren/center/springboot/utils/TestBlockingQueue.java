package com.darren.center.utils;

import com.darren.center.entity.Comsumer;
import com.darren.center.entity.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueue {


    public static void main(String args[]){
        BlockingQueue blockingQueue = new LinkedBlockingQueue();
        Thread producer = new Thread(new Producer(blockingQueue));
        Thread consumer = new Thread(new Comsumer(blockingQueue));
        producer.start();
        consumer.start();
    }
}
