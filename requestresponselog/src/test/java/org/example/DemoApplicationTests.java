package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void givenRequest_whenFetchTaxiFareRateCard_thanOK() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		TaxiRide taxiRide = new TaxiRide(true, 10l);
		String fare = testRestTemplate.postForObject(
				"http://127.0.0.1:8080/taxifare/calculate/",
				taxiRide, String.class);

		assertThat(fare, equalTo("200"));
	}


}
