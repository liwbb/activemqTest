package com.activemq.jmstest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Message;

/**
 * 消费者
 */
@Service
public class QueueReceiver {
    @Autowired
    private JmsTemplate jt;

    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext
                ("activemq-spring.xml");
        QueueReceiver ct = (QueueReceiver) ctx
                .getBean("queueReceiver");

        String msg = (String) ct.jt.receiveAndConvert();

        System.out.println("msg===" + msg);
    }
}
