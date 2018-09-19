package com.fanhuajun.codestandard.mq.mq2;

import org.junit.Test;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A simple demo for producer client to send message to ActiveMQ.<br>
 * 对{@link cn.sinobest.asj.producer.jms.clientmode.SimpleProducer}的改进. https://www.cnblogs.com/ywjy/articles/5434776.html
 * 
 * @author lijinlong
 * 
 */
public class SimpleProducer {
    /** JNDI name for ConnectionFactory */
    static final String CONNECTION_FACTORY_JNDI_NAME = "ConnectionFactory";
    /** JNDI name for Queue Destination (use for PTP Mode) */
    static final String QUEUE_JNDI_NAME = "exampleQueue";
    /** JNDI name for Topic Destination (use for Pub/Sub Mode) */
    static final String TOPIC_JNDI_NAME = "exampleTopic";

    /**
     * 发送消息到队列.<br>
     * PTP Mode.
     */
    @Test
    public void sendToQueue() {
        send(QUEUE_JNDI_NAME);
    }

    /**
     * 发送消息到主题.<br>
     * PTP Mode.
     */
    @Test
    public void sendToTopic() {
        send(TOPIC_JNDI_NAME);
    }

    /**
     * 发送到指定的目的地.
     * 
     * @param destJndiName
     *            目的地的JNDI name：{@link #QUEUE_JNDI_NAME}或 {@link #TOPIC_JNDI_NAME}.
     */
    private void send(String destJndiName) {
        Context jndiContext = null;
        ConnectionFactory connectionFactory = null;
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageProducer producer = null;
        // create a JNDI API IntialContext object
        try {
            jndiContext = new InitialContext();
        } catch (NamingException e) {
            System.out.println("Could not create JNDI Context:" + e.getMessage());
            System.exit(1);
        }
        // look up ConnectionFactory and Destination
        try {
            connectionFactory = (ConnectionFactory) jndiContext.lookup(CONNECTION_FACTORY_JNDI_NAME);
            destination = (Destination) jndiContext.lookup(destJndiName);
        } catch (NamingException e) {
            System.out.println("JNDI look up failed:" + e.getMessage());
            System.exit(1);
        }
        // send Messages and finally release the resources.
        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            for (int i = 0; i < 3; i++) {
                message.setText(String.format("This is the %dth message.", i + 1));
                producer.send(message);
            }
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
