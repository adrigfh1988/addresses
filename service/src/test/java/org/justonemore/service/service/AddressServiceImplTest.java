package org.justonemore.service.service;

import config.IntegrationTestSpringContext;
import config.PostgresIntegrationSetup;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = IntegrationTestSpringContext.class)
class AddressServiceImplTest extends PostgresIntegrationSetup {

	@Autowired
	AddressServiceImpl addressService;

	@Test
	void demo(){

		//TODO: First testing draft

	}

}