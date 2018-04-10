/*
 * @(#)ReceiveConsumer.java 2018年4月10日
 * 
 * Copyright (c), 2018 万科物业发展有限公司
 * 
 * 著作权人保留一切权利，任何使用需经授权。
 */
package com.fanhuajun.codestandard.service.mq.mq2;

import java.util.concurrent.CountDownLatch;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author fanhuajun
 * @date 2018年4月10日 下午5:58:54
 * @version V1.0.0
 * @description：
 * 
 */
public class ReceiveConsumer {
    
    CountDownLatch latch = new CountDownLatch(1);
    
    /**
     * 接收消息.<br>
     * 
     * @param listener
     *            监听器，如果消息接收成功，将被回调.
     */
    public void receive(MessageListener listener) {
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer consumer = null;
        // look up ConnectionFactory and Destination
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://10.0.73.176:61616");
        // receive Messages and finally release the resources.
        try {
            connection = connectionFactory.createConnection();
            connection.start(); // connection should be called in
                                // receiver-client
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("FirstQueue");
            consumer = session.createConsumer(destination);
            // key code for asynchronous receive:set messageListener
            consumer.setMessageListener(listener);
            try {
                latch.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // Hold.hold(); // 阻塞程序继续执行
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null)
                    session.close();
                if (connection != null)
                    connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
