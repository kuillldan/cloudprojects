package org.lyk;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by yuankliu on 18/05/2018.
 */
public class Worker
{
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.104");
        factory.setUsername("root");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        boolean queueDurable = true;
        channel.queueDeclare(QUEUE_NAME, queueDurable, false, false, null);
        System.out.println("[*] Waiting for messages. To exit press CTRL + C");
        Consumer consumer = new DefaultConsumer(channel)
        {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException
            {
                String message = new String(body, "UTF-8");
                System.out.println("[x] Received '" + message + "'");
                try
                {
                    doWork(message);
                } catch (Exception e)
                {
                    e.printStackTrace();
                } finally
                {
                    System.out.println(" [x] Done");
                }
            }
        };
        boolean autoAck = true;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }

    private static void doWork(String task) throws InterruptedException
    {
        for (char ch : task.toCharArray())
        {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
