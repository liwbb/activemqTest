package com.activemq.jmstest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.applet.AppletContext;

/**
 * 消息生产者
 */
@Service
public class QueueSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext
                ("activemq-spring.xml");
        QueueSender queueSender= (QueueSender) applicationContext.getBean("queueSender");
        queueSender.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage=session.createTextMessage("message444==>");
                return textMessage;
            }
        });
    }
}
