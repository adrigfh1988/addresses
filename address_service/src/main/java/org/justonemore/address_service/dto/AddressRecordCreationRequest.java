package org.justonemore.address_service.dto;

public record AddressRecordCreationRequest(String personIdentifier, String city, String province, String country,
		String streetName, String postalCode, String streetType) {
}
