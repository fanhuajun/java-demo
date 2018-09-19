package com.fanhuajun.codestandard.mq.mq2;

import org.junit.Test;

import javax.jms.*;

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
    
    ReceiveConsumer receiveConsumer = new ReceiveConsumer();
    
    /**
     * 从主题接收消息.
     */
    @Test
    public void receive() {
        receiveConsumer.receive(createMessageListener(), Session.DUPS_OK_ACKNOWLEDGE, null);
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
    
}

