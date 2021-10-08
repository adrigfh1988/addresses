package org.justonemore.address_service.service;

import config.PostgresIntegrationSetup;
import org.junit.jupiter.api.Test;
import org.justonemore.address_service.component.AddressMapper;
import org.justonemore.persistence.repository.AddressRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "org.justonemore.persistence.repository" })
@SpringBootTest(classes = { AddressRepository.class, AddressService.class, AddressMapper.class })
class AddressServiceTest extends PostgresIntegrationSetup {

	@SpringBootApplication
	static class TestConfiguration {

	}

	@Autowired
	AddressService addressService;

	@Autowired
	AddressRepository addressRepository;

	@Test
	void demo() {

	}

}