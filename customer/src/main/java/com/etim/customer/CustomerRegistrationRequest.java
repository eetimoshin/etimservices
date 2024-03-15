package com.etim.customer;

public record CustomerRegistrationRequest
        (String firstname,
        String lastname,
        String email) {
}
