package app.kumquat.services.other.mq;

import app.kumquat.services.other.model.AMQPException;
import com.rabbitmq.client.*;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MqStore {

    static final Logger log = LoggerFactory.getLogger(MqStore.class);
    private static final String EXCHANGE_NAME = "kumquat_amqp_channel";

    private Channel channel;
    private Connection connection;


    private Connection getOrCreateConnection() {
        if (connection != null) {
            return connection;
        }
        ConnectionFactory factory = new ConnectionFactory();
        try {
            factory.setUri("amqp://kumquat:kumquat@localhost:5672/");
            factory.setVirtualHost("/");
            connection = factory.newConnection();
        } catch (Exception e) {
            throw new AMQPException(e);
        }

        return connection;
    }

    private Channel getOrCreateChannel() {
        if (channel != null) {
            return channel;
        }
        try {
            channel = getOrCreateConnection().createChannel();
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        } catch (Exception e) {
            throw new AMQPException(e);
        }
        return channel;
    }

    public void sendMessage(String jsonMessage) {
        try {
            getOrCreateChannel().basicPublish(EXCHANGE_NAME, "", null, StringUtils.getBytesUtf8(jsonMessage));
        } catch (Exception e) {
            throw new AMQPException(e);
        }
    }


    public void applyReceiverCallback(DeliverCallback deliverCallback) {
        try {
            getOrCreateChannel().basicConsume("test_subscribe_kumquat", true, deliverCallback, consumerTag -> { });
        } catch (IOException e) {
            throw new AMQPException(e);
        }
    }

}
