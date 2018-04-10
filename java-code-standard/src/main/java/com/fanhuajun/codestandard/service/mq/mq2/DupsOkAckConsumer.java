package com.fanhuajun.codestandard.service.mq.mq2;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;
/**
 * DUPS_OK_ACKNOWLEDGE确认模式的Consumer.<br>
 * @author lijinlong
 *
 */
public class DupsOkAckConsumer {
    /** JNDI name for ConnectionFactory */
    static final String CONNECTION_FACTORY_JNDI_NAME = "ConnectionFactory";
    /** JNDI name for Topic Destination (use for Pub/Sub Mode) */
    static final String TOPIC_JNDI_NAME = "exampleTopic";
    
    /**
     * 从主题接收消息.
     */
    @Test
    public void receive() {
        receive(createMessageListener());
    }
    
    /**
     * 创建MessageListener实例.
     * @return
     */
    private MessageListener createMessageListener() {
        MessageListener listener = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    String text = ((TextMessage) message).getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        
        return listener;
    }
    
    /**
     * 接收消息.<br>
     * 
     * @param listener
     *            监听器，如果消息接收成功，将被回调.
     */
    private void receive(MessageListener listener) {
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer consumer = null;
        // create a JNDI API IntialContext object
        try {
            jndiContext = new InitialContext();
        } catch (NamingException e) {
            System.out.println("Could not create JNDI Context:"
                    + e.getMessage());
            System.exit(1);
        }
        // look up ConnectionFactory and Destination
        try {
            connectionFactory = (ConnectionFactory) jndiContext
                    .lookup(CONNECTION_FACTORY_JNDI_NAME);
            destination = (Destination) jndiContext.lookup(TOPIC_JNDI_NAME);
        } catch (NamingException e) {
            System.out.println("JNDI look up failed:" + e.getMessage());
            System.exit(1);
        }
        // receive Messages and finally release the resources.
        try {
            connection = connectionFactory.createConnection();
            connection.start(); // connection should be called in
                                // receiver-client
            session = connection.createSession(Boolean.FALSE,
                    Session.DUPS_OK_ACKNOWLEDGE);
            consumer = session.createConsumer(destination);
            // key code for asynchronous receive:set messageListener
            consumer.setMessageListener(listener);
//            Hold.hold(); // 阻塞程序继续执行
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

