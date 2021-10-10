package org.justonemore.controller;

import org.justonemore.service.service.AddressServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {

	private final AddressServiceImpl addressService;

	public AddressController(AddressServiceImpl addressService) {
		this.addressService = addressService;
	}

	@GetMapping
	public String test() {
		return "TEST";
	}

}
