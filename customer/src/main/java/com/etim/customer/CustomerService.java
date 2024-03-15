package com.etim.customer;

import com.etim.amqp.RabbitMQMessageProducer;
import com.etim.clients.fraud.FraudClient;
import com.etim.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;

    private final FraudClient fraudClient;

    private final RabbitMQMessageProducer producer;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

        fraudClient.isFraud(customer.getId());

        NotificationRequest request1 = new NotificationRequest(
                customer.getId(), customer.getEmail(),
                String.format("Hi %s, i am glad to meet you here!", customer.getFirstname()));

        producer.publish(request1, "internal.exchange", "routing-key");
    }
}
