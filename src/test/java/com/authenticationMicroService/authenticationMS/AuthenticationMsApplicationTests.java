package com.authenticationMicroService.authenticationMS;

import Service.BasicTestClass;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AuthenticationMsApplicationTests {


	@InjectMocks
	BasicTestClass basicTestClass;

	@Test
	void contextLoads() {
	}

	@Test
	public void basicTest(){
		List<Integer> list = Arrays.asList(6,3,8,9,2,5);
		int target = 11;
		boolean result = basicTestClass.isExists(list,target);
		assertNotNull(result);
		assertTrue(result);
	}

}
