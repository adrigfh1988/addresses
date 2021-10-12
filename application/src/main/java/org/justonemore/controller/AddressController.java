package org.justonemore.controller;

import org.justonemore.service.dto.AddressRecordCreationRequest;
import org.justonemore.service.dto.AddressResponseRecord;
import org.justonemore.service.service.AddressServiceImpl;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AddressController {

	private final AddressServiceImpl addressService;

	public AddressController(AddressServiceImpl addressService) {
		this.addressService = addressService;
	}

	@PostMapping(value = "/create-address")
	public ResponseEntity<Mono<AddressResponseRecord>> createAddress(
			@RequestBody AddressRecordCreationRequest addressRecordCreationRequest) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(addressService.createAddress(addressRecordCreationRequest));

	}

}
