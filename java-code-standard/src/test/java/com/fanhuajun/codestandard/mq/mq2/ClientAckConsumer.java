package com.fanhuajun.codestandard.mq.mq2;

import org.junit.Test;

import javax.jms.*;

/**
 * CLIENT_ACKNOWLEDGE确认模式的Consumer.<br>
 * 基于PTP Mode，采用异步的方式接收消息，研究从不确认、每2次确认的情况下，Queue中的消息的出队情况.<br>
 * 
 * @author lijinlong
 * 
 */
public class ClientAckConsumer {
    /** JNDI name for ConnectionFactory */
    static final String CONNECTION_FACTORY_JNDI_NAME = "ConnectionFactory";
    /** JNDI name for Queue Destination (use for PTP Mode) */
    static final String QUEUE_JNDI_NAME = "exampleQueue";
    
    ReceiveConsumer receiveConsumer = new ReceiveConsumer();
    /**
     * 从不确认的接收.<br>
     * 结果：
     * <ul>
     *     <li>只接收一次，但是消息不会出队.</li>
     *  <li>Consumer重启，会再次接收到消息.</li>
     * </ul>
     */
    @Test
    public void receiveWithoutAck() {
        MessageListener listener = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    String text = ((TextMessage) message).getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                
                try {
                    System.out.println("睡眠5秒");
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        receiveConsumer.receive(listener, Session.CLIENT_ACKNOWLEDGE, null);
    }
    
    private int ack_count = 0; // 确认次数统计
    /**
     * 每接收两次确认一次.<br>
     * 结果：每次确认不是只对当前的Message进行确认，而是对自上次确认以来的所有Message进行确认.在这里，每次确认2条.
     */
    @Test
    public void receivePerTwice() {
        MessageListener listener = new MessageListener() {
            public void onMessage(Message message) {
                try {
                    String text = ((TextMessage) message).getText();
                    System.out.println(text);
                    
                    ack_count ++;
                    if (ack_count % 2 == 0){
                        System.out.println("客户端确认");
                        message.acknowledge();
                    }
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
        receiveConsumer.receive(listener, Session.CLIENT_ACKNOWLEDGE, null);
    }
}

