package com.fanhuajun.codestandard.service.mq.mq2;

import java.util.concurrent.CountDownLatch;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

/**
 * AUTO_ACKNOWLEDGE确认模式的Consumer.<br>
 * 基于PTP Mode，采用异步的方式接收消息，研究抛出或不抛出异常的情况下，Queue中的消息的出队情况.<br>
 * 
 * @author lijinlong
 * 
 */
public class AutoAckConsumer {
    /** JNDI name for ConnectionFactory */
    static final String CONNECTION_FACTORY_JNDI_NAME = "ConnectionFactory";
    /** JNDI name for Queue Destination (use for PTP Mode) */
    static final String QUEUE_JNDI_NAME = "exampleQueue";
    
    ReceiveConsumer receiveConsumer = new ReceiveConsumer();

    /**
     * 正常的接收.<br>
     */
    @Test
    public void receiveNormal() {
        MessageListener listener = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    String text = ((TextMessage) message).getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        };
        receiveConsumer.receive(listener);
    }

    /**
     * 故意抛出异常的接收.<br>
     * 结果：
     * <ul>
     * <li>JMS Provider重复发送消息给Consumer。重复次数达到一定的阀值，JMS Provider认为此消息无法消费，此消息将会被删除或者迁移到"dead letter"通道中。</li>
     * <li>在测试过程中，会重发6次（共发7次），然后移到ActiveMQ.DLQ队列；DLQ - dead letter queue.</li>
     * <li>重发次数可以配置 - 在brokerUrl中指定参数jms.redeliveryPolicy.maximumRedeliveries=3，则重发3次（共4次）.</li>
     * </ul>
     */
    @Test
    public void receiveIntentionalException() {
        MessageListener listener = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    String text = ((TextMessage) message).getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                boolean intentional = true;
                if (intentional) {
                    throw new RuntimeException("故意抛出的异常。");
                }
            }
        };
        receiveConsumer.receive(listener);
    }

    
}
