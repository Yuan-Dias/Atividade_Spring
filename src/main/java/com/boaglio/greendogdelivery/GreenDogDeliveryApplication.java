package com.boaglio.greendogdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/* @RestController */
public class    GreenDogDeliveryApplication {

    /*
	@GetMapping("/") 
    public String ola() {
        return "Olá, Green Dog Delivery está no ar!";
    }
    */

    public static void main(String[] args) {
        SpringApplication.run(GreenDogDeliveryApplication.class, args);
    }
}