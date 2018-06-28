package com.fanhuajun.codestandard.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutorService {
	final static ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
	
	public static void main(String[] args) {
		
		
	}
	
	public static void thread1 () {
		int count = 100;
		CountDownLatch latch = new CountDownLatch(count);
		// new SynchronousQueue<Runnable>()
		
		Runnable myRunnable = new Runnable() {
		    @Override
		    public void run() {
		        try {
		            Thread.sleep(2);
		            System.out.println(Thread.currentThread().getName() + " run");
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } finally {
		        	latch.countDown();
				}

		    }
		};
		
		for (int i=0 ; i<count ; i++) {
			executor.execute(myRunnable);
		}
		
		try {
            latch.await();
        } catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
	}
	
	public static void thread2 () {
		Future<?> future = executor.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + " run");
				
			}
		});
		
	}

}
