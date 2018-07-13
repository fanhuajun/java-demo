package com.fanhuajun.codestandard;

import java.lang.reflect.Method;

import org.junit.Test;

import com.fanhuajun.codestandard.config.PropertiesConfig;

public class ReflectTest extends TestBase {

	@SuppressWarnings("rawtypes")
	@Test
	public void test1() {
		try {
			Class clazz = Class.forName("com.fanhuajun.codestandard.config.PropertiesConfig");

			// 2、获取main方法
			Method methodMain = clazz.getMethod("setType3",String.class);// 第一个参数：方法名称，第二个参数：方法形参的类型，
			methodMain.invoke(null, (Object) new String("d"));// 方式一
			logger.info("clazz", clazz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
