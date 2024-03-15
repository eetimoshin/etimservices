package com.etim.notification;

import com.etim.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService service;

    @RabbitListener(queues = "notification")
    public void consume(NotificationRequest request) {
        log.info("Consumed: {}", request);
        service.send(request);
    }
}
