package com.alice.jmx;

/**
 * Hello world!
 *
 */
public class JmxApp {
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		try {
			JmxManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}