package org.justonemore.service.service;

import java.util.Arrays;

import config.IntegrationTestSpringContext;
import config.PostgresIntegrationSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.justonemore.persistence.repository.AddressRepository;
import org.justonemore.service.dto.AddressRecordCreationRequest;
import org.justonemore.service.dto.AddressResponseRecord;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.r2dbc.core.DatabaseClient;

@SpringBootTest(classes = IntegrationTestSpringContext.class)

class AddressServiceImplTest extends PostgresIntegrationSetup {

	@Autowired
	AddressServiceImpl addressService;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	DatabaseClient database;

	@Nested
	class CreateAddressTest {

		@BeforeEach
		void resetDataset() {

			var statements = Arrays.asList(//
					"DROP TABLE IF EXISTS address;", """
							Create table address(
							    id SERIAL PRIMARY KEY,
							    person_identifier character varying(10) NOT NULL,
							    city character varying(60) NOT NULL,
							    province character varying(60) NOT NULL,
							    country character varying(60) NOT NULL,
							    street_name character varying(255) NOT NULL,
							    postal_code character varying(5) NOT NULL,
							    street_type character varying(10) NOT NULL
							);""");

			statements.forEach(it -> database.sql(it) //
					.fetch() //
					.rowsUpdated() //
					.as(StepVerifier::create) //
					.expectNextCount(1) //
					.verifyComplete());
		}

		@Test
		@DisplayName("In this test is going to be validated the multiple creation of records using R2DBC")
		void createMultipleAddressTest() {

			Mono<AddressResponseRecord> address = addressService.createAddress(new AddressRecordCreationRequest(
					"F00000001", "MADRID", "MADRID", "SPAIN", "andres de urdaneta 1", "28045", "CL"));

			Mono<AddressResponseRecord> address2 = addressService.createAddress(new AddressRecordCreationRequest(
					"F00000001", "MADRID", "MADRID", "SPAIN", "andres de urdaneta 2", "28045", "CL"));

			Mono<AddressResponseRecord> address3 = addressService.createAddress(new AddressRecordCreationRequest(
					"F00000001", "MADRID", "MADRID", "SPAIN", "andres de urdaneta 3", "28045", "CL"));

			Mono<AddressResponseRecord> address4 = addressService.createAddress(new AddressRecordCreationRequest(
					"F00000001", "MADRID", "MADRID", "SPAIN", "andres de urdaneta 4", "28045", "CL"));

			StepVerifier.create(address).expectNext(new AddressResponseRecord(1)).expectComplete().verify();
			StepVerifier.create(address2).expectNext(new AddressResponseRecord(2)).expectComplete().verify();
			StepVerifier.create(address3).expectNext(new AddressResponseRecord(3)).expectComplete().verify();
			StepVerifier.create(address4).expectNext(new AddressResponseRecord(4)).expectComplete().verify();

		}

		@Test
		@DisplayName("In this test is going twe are validating the duplicated validation")
		void createAddressErrorOnDuplicateTest() {

			Mono<AddressResponseRecord> address = addressService.createAddress(new AddressRecordCreationRequest(
					"F00000001", "MADRID", "MADRID", "SPAIN", "andres de urdaneta 1", "28045", "CL"));

			StepVerifier.create(address).expectNext(new AddressResponseRecord(1)).expectComplete().verify();

			Mono<AddressResponseRecord> address2 = addressService.createAddress(new AddressRecordCreationRequest(
					"F00000001", "MADRID", "MADRID", "SPAIN", "andres de urdaneta 1", "28045", "CL"));

			StepVerifier.create(address2).expectErrorMessage("ADDRESS DUPLICATED").verify();

		}

	}

}