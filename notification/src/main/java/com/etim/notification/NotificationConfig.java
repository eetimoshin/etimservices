package com.etim.notification;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class NotificationConfig {
    @Value("${rabbitmq.exchanges.internal}")
    private String exchangeType;

    @Value("${rabbitmq.queue.queue-name}")
    private String queueName;

    @Value("${rabbitmq.routing-key.key}")
    private String queueKey;

    @Bean
    public TopicExchange getExchange() {
        return new TopicExchange(this.exchangeType);
    }

    @Bean
    public Queue getQueue() {
        return new Queue(this.queueName);
    }

    @Bean
    public Binding bindQueueToExchange() {
        return BindingBuilder.bind(getQueue())
                .to(getExchange())
                .with(this.queueKey);
    }
}
