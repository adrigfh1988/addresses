package org.justonemore.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.justonemore.service.dto.AddressRecordCreationRequest;
import org.justonemore.service.dto.AddressResponseRecord;
import org.justonemore.service.service.AddressServiceImpl;
import org.mockito.Mockito;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;
import org.springframework.web.reactive.function.BodyInserters;

import static org.mockito.ArgumentMatchers.any;

@WebFluxTest(controllers = AddressController.class)
class AddressControllerTest {

	@MockBean
	AddressServiceImpl addressService;

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void createAddressControllerOkTest() {

		AddressResponseRecord expectedResult = new AddressResponseRecord(1);
		Mockito.when(addressService.createAddress(any())).thenReturn(Mono.just(expectedResult));
		AddressRecordCreationRequest addressRecordCreationRequest = new AddressRecordCreationRequest("F00000001",
				"MADRID", "MADRID", "SPAIN", "andres de urdaneta", "28045", "CL");

		ResponseSpec created = webTestClient.post().uri("/create-address").contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(addressRecordCreationRequest)).exchange().expectStatus().isCreated();

		AddressResponseRecord actualResult = created.expectBody(AddressResponseRecord.class).returnResult()
				.getResponseBody();

		Assertions.assertEquals(expectedResult, actualResult);
		Mockito.verify(addressService).createAddress(addressRecordCreationRequest);
	}

}