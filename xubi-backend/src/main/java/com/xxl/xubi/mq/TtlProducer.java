package com.xxl.xubi.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

/**
 * 队列消息过期机制-生产者
 */
public class TtlProducer {

    private final static String QUEUE_NAME = "ttl_queue";

    public static void main(String[] argv) throws Exception {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.100.109");
        factory.setUsername("admin");
        factory.setPassword("admin");
//        factory.setUsername();
//        factory.setPassword();
//        factory.setPort();

        // 建立连接、创建频道
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 发送消息
            String message = "Hello World!";

            // 给消息指定过期时间
            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .expiration("10000")
                    .build();
//            channel.basicPublish("my-exchange", "routing-key", properties, message.getBytes(StandardCharsets.UTF_8));
//            channel.basicPublish("my-exchange", QUEUE_NAME, properties, message.getBytes(StandardCharsets.UTF_8));
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}