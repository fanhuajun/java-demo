/*
 * @(#)MultipleDataSource.java 2018年4月11日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.service.jdbc;

/*import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

*//**
 * https://www.cnblogs.com/lzrabbit/p/3750803.html
 * Created by rabbit on 14-5-25.
 *//*
public class MultipleDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}*/