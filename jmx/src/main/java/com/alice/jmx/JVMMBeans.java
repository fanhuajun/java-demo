package com.alice.jmx;

import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.Set;
 
import javax.management.MBeanServer;
import javax.management.ObjectInstance;

public class JVMMBeans {
	
	public static void main(String[] args) {
		ListAll();
	}
	
	private static void ListAll(){
		
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        
        Set instances = server.queryMBeans(null, null);
         
        Iterator iterator = instances.iterator();
         
        while (iterator.hasNext()) {
            ObjectInstance instance = (ObjectInstance) iterator.next();
            System.out.println("MBean Found:");
            System.out.println("Class Name:\t" + instance.getClassName());
            System.out.println("Object Name:\t" + instance.getObjectName());
            System.out.println("****************************************");
        }
		
	}

}


