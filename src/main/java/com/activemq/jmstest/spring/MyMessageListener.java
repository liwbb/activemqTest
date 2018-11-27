package com.activemq.jmstest.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 监听==作为消费者不需要重新启动消费者
 */
public class MyMessageListener implements MessageListener {
    @Override
    public void onMessage(Message msg) {
        TextMessage txtMsg = (TextMessage)msg;
        try {
            System.out.println("receive txt msg==="+txtMsg.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
