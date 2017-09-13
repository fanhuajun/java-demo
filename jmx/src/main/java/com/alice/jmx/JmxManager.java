package com.alice.jmx;

import java.lang.management.MemoryUsage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * http://yunzhu.iteye.com/blog/1554869
 * @author fanhuajun
 *
 */
public class JmxManager {

	static JMXConnector connector = null;

	static MBeanServerConnection mbsc = null;

	public static void getConnection() throws Exception {

		// 用户名、密码
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("jmx.remote.credentials", new String[] { "monitorRole", "QED" });
		//service:jmx:rmi:///jndi/rmi://10.0.76.32:10086/jmxrmi
		String jmxURL = "service:jmx:rmi:///jndi/rmi://10.0.76.32:10086/jmxrmi";

		JMXServiceURL serviceURL = new JMXServiceURL(jmxURL);
		connector = JMXConnectorFactory.connect(serviceURL, map);
		mbsc = connector.getMBeanServerConnection();
		
		System.out.println("连接成功");
		
		getMemory();

	}

	private static void getobjectName() throws Exception {

		Set MBeanset = mbsc.queryMBeans(null, null);
		Iterator MBeansetIterator = MBeanset.iterator();
		while (MBeansetIterator.hasNext()) {
			ObjectInstance objectInstance = (ObjectInstance) MBeansetIterator.next();
			ObjectName objectName = objectInstance.getObjectName();
			MBeanInfo objectInfo = mbsc.getMBeanInfo(objectName);
			System.out.print("ObjectName:" + objectName.getCanonicalName() + ".");
			System.out.print("mehtodName:");
			for (int i = 0; i < objectInfo.getAttributes().length; i++) {
				System.out.print(objectInfo.getAttributes()[i].getName() + ",");
			}
			System.out.println();
		}

	}

	private static void getMemory() throws Exception {

		ObjectName heapObjName = new ObjectName("java.lang:type=Memory");

		// 堆内存
		MemoryUsage heapMemoryUsage = MemoryUsage
				.from((CompositeDataSupport) mbsc.getAttribute(heapObjName, "HeapMemoryUsage"));
		long commitMemory = heapMemoryUsage.getCommitted();// 堆当前分配
		long usedMemory = heapMemoryUsage.getUsed();
		System.out.print("堆内存总量:" + heapMemoryUsage.getMax() / 1024 + "KB,当前分配量:" + commitMemory / 1024 + "KB,当前使用率:"
				+ usedMemory / 1024 + "KB,");
		System.out.println("堆内存使用率:" + (int) usedMemory * 100 / commitMemory + "%");// 堆使用率

		// 栈内存
		MemoryUsage nonheapMemoryUsage = MemoryUsage
				.from((CompositeDataSupport) mbsc.getAttribute(heapObjName, "NonHeapMemoryUsage"));
		long noncommitMemory = nonheapMemoryUsage.getCommitted();
		long nonusedMemory = heapMemoryUsage.getUsed();

		System.out.println("栈内存使用率:" + (int) nonusedMemory * 100 / noncommitMemory + "%");

		
		
		ObjectName runtimeObjName = new ObjectName("java.lang:type=Runtime");    
		System.out.println("厂商:" + (String) mbsc.getAttribute(runtimeObjName,"VmVendor"));
		
		
		// PermGen内存
		ObjectName permObjName = new ObjectName("java.lang:type=MemoryPool,name=Perm Gen");
		Object object1  = mbsc.getAttribute(permObjName, "Usage");

		MemoryUsage permGenUsage = MemoryUsage.from((CompositeDataSupport) object1);
		long committed = permGenUsage.getCommitted();// 持久堆大小
		long used = heapMemoryUsage.getUsed();//
		System.out.println("perm gen:" + (int) used * 100 / committed + "%");// 持久堆使用率

	}

	private static void getMemory1() throws Exception {
		ObjectName youngHeapObjName = new ObjectName("java.lang:type=MemoryPool,name=Eden Space");
		// 获取Mbean对象
		MBeanInfo youngHeapInfo = mbsc.getMBeanInfo(youngHeapObjName);
		// 获取对象的属性
		MBeanAttributeInfo[] youngHeapAttributes = youngHeapInfo.getAttributes();

		MemoryUsage youngHeapUsage = MemoryUsage
				.from((CompositeDataSupport) mbsc.getAttribute(youngHeapObjName, "Usage"));

		System.out.print("目前新生区分 配最大内存:" + youngHeapUsage.getMax() / 1024 + "KB,");
		System.out.print("新生区已分配:" + youngHeapUsage.getCommitted() / 1024 + "KB,");
		System.out.print("新生区初始化:" + youngHeapUsage.getInit() / 1024 + "KB,");
		System.out.println("新生区已使用" + youngHeapUsage.getUsed() / 1024 + "KB");
	}

	private static void getThread() throws Exception {

		ObjectName managerObjName = new ObjectName("Catalina:type=Manager,*");
		Set<ObjectName> s = mbsc.queryNames(managerObjName, null);
		for (ObjectName obj : s) {

			ObjectName objname = new ObjectName(obj.getCanonicalName());
			System.out.print("objectName:" + objname);
			System.out.print(",最大会话数:" + mbsc.getAttribute(objname, "maxActiveSessions") + ",");
			System.out.print("会话数:" + mbsc.getAttribute(objname, "activeSessions") + ",");
			System.out.println("活动会话数:" + mbsc.getAttribute(objname, "sessionCounter"));

		}

	}

}
