package org.lyk;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 */
public class EmitLog
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
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String routingKey = "corn.critical";
        channel.basicPublish(EXCHANGE_NAME, routingKey, null, routingKey.getBytes());
        channel.close();
        connection.close();
    }
}
