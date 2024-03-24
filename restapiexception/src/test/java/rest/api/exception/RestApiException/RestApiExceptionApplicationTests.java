package rest.api.exception.restapiexception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class RestapiexceptionApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void givenRequest_user_not_found_exception() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		UserId id = new UserId();
		id.setId(100);

		String fare = testRestTemplate.postForObject(
				"http://127.0.0.1:8080/userId/",
				id, String.class);

		//{"code":"USER_NOT_FOUND","message":"Could not find user with id 100"}
		System.out.println(fare);
	}

	@Test
	public void givenRequest_method_argument_not_valid_exception() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ExampleRequestBody requestBody = new ExampleRequestBody();
		requestBody.setName("");
		requestBody.setFavoriteMovie("");

		String fare = testRestTemplate.postForObject(
				"http://127.0.0.1:8080/reqException/",
				requestBody, String.class);

		//{"code":"VALIDATION_FAILED","message":"Validation failed for object='exampleRequestBody'. Error count: 2","fieldErrors":[{"code":"REQUIRED_NOT_BLANK","message":"空白は許可されていません","property":"favoriteMovie","rejectedValue":"","path":"favoriteMovie"},{"code":"INVALID_SIZE","message":"10 から 2147483647 の間のサイズにしてください","property":"name","rejectedValue":"","path":"name"}]}
		// {"status":400,"code":"VALIDATION_FAILED","message":"Validation failed for object='exampleRequestBody'. Error count: 2","fieldErrors":[{"code":"REQUIRED_NOT_BLANK","message":"空白は許可されていません","property":"favoriteMovie","rejectedValue":"","path":"favoriteMovie"},{"code":"INVALID_SIZE","message":"10 から 2147483647 の間のサイズにしてください","property":"name","rejectedValue":"","path":"name"}]}
		System.out.println(fare);
	}

	@Test
	public void givenRequest_method_not_allowed_exception() {
		TestRestTemplate testRestTemplate = new TestRestTemplate();
		ExampleRequestBody requestBody = new ExampleRequestBody();
		requestBody.setName("");
		requestBody.setFavoriteMovie("");

		String fare = testRestTemplate.getForObject(
				"http://127.0.0.1:8080/reqException/", String.class);

		// {"timestamp":"2024-03-23T09:37:49.887+00:00","status":405,"error":"Method Not Allowed","path":"/reqException/"}
		System.out.println(fare);
	}












}
