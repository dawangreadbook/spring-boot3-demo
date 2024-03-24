package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TaxiFareController {

    @Autowired
    private TaxiFareCalculatorService taxiFareCalculatorService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxiFareController.class);

//    @GetMapping("/taxifare/get/")
//    public RateCard getTaxiFare() {
//        LOGGER.info("getTaxiFare() - START");
//        return new RateCard();
//    }

    @PostMapping("/taxifare/calculate/")
    public String calculateTaxiFare(@RequestBody @Valid TaxiRide taxiRide) {
        LOGGER.info("calculateTaxiFare() - START");
        String totalFare = taxiFareCalculatorService.calculateFare(taxiRide);
        LOGGER.info("calculateTaxiFare() - Total Fare : {}",totalFare);
        LOGGER.info("calculateTaxiFare() - END");
        return totalFare;
    }

}