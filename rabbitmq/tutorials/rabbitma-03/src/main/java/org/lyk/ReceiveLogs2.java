package org.lyk;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by yuankliu on 18/05/2018.
 */
public class ReceiveLogs2
{

    private static final String EXCHANGE_NAME = "logs";
    public static void main(String[] args) throws Exception
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.1.104");
        factory.setUsername("root");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        System.out.println("[*] Waiting for messages. To exit press CTRL + C");
        channel.queueBind(queueName,EXCHANGE_NAME,"");
        Consumer consumer = new DefaultConsumer(channel)
        {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException
            {
                String message = new String(body, "UTF-8");
                System.out.println("[2] Received '" + message + "'");
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
        channel.basicConsume(queueName, autoAck, consumer);
    }

    private static void doWork(String task) throws InterruptedException
    {
        for (char ch : task.toCharArray())
        {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
