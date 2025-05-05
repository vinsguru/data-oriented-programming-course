package com.vinsguru;

import com.vinsguru.sec01.application.model.Payment;
import com.vinsguru.sec01.application.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneTableApproachTest {

	private static final Logger log = LoggerFactory.getLogger(OneTableApproachTest.class);

	@Autowired
	private PaymentService paymentService;

	@Test
	void entitySaveRetrieve() {

		// save credit card
		var creditCard = new Payment.CreditCard("123-456-789", "123");
		this.paymentService.save(creditCard);

		// save paypal
		var paypal = new Payment.Paypal("sam@gmail.com");
		this.paymentService.save(paypal);

		// query by id
		log.info("{}", this.paymentService.getPayment(1));
		log.info("{}", this.paymentService.getPayment(2));

		// query all
		this.paymentService.printAllRecords();

	}

}
