package com.fanhuajun.codestandard.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutorService {
	
	public static void main(String[] args) {
		int count = 22;
		CountDownLatch latch = new CountDownLatch(count);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(22));
		
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

}
