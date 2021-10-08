package org.justonemore.application.controller;

import org.justonemore.address_service.service.AddressService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {

	private final AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@GetMapping
	public String test() {
		return "TEST";
	}

}
