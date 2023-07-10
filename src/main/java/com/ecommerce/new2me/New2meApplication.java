package com.ecommerce.new2me;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class New2meApplication {

	@PostConstruct
	public void setup(){
		Stripe.apiKey="sk_test_51NFdorLy6s9umgHClGnHiF1qTm9Smgqp7KtSXbFaCqoXmNSeHwFawAjibjLFwxAPkUZlPNUmTUD7vud5tqwavuk400X6c9AkyR";
	}

	public static void main(String[] args) {
		SpringApplication.run(New2meApplication.class, args);
	}

}
