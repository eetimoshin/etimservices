package com.etim.fraud;

import com.etim.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Integer customerId){
        boolean isFraud = fraudCheckService.isCustomerFraud(customerId);
        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponse(isFraud);
    }

}
