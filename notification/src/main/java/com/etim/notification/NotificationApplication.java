package com.etim.notification;


import com.etim.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"com.etim.notification", "com.etim.amqp"})
@PropertySources(
        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfig config) {
//        return args -> producer.publish("foo", config.getExchangeType(), config.getQueueKey());
//    }
}



