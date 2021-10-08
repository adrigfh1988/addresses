package org.justonemore.address_service.component;

import org.justonemore.address_service.dto.AddressRecordCreationRequest;
import org.justonemore.address_service.dto.AddressResponseRecord;
import org.justonemore.persistence.entity.Address;

import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

	public Address mapRequestToEntity(AddressRecordCreationRequest addressRecordCreationRequest, Integer id) {

		return new Address(id, addressRecordCreationRequest.personIdentifier(),
				addressRecordCreationRequest.city(), addressRecordCreationRequest.province(),
				addressRecordCreationRequest.country(), addressRecordCreationRequest.streetName(),
				addressRecordCreationRequest.postalCode(), addressRecordCreationRequest.streetType());
	}

	public AddressResponseRecord mapEntityToResponse(Address address) {
		return new AddressResponseRecord(address.id());
	}

}
