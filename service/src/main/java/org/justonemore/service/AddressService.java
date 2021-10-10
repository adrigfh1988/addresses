package org.justonemore.service;

import org.justonemore.service.dto.AddressRecordCreationRequest;
import org.justonemore.service.dto.AddressResponseRecord;
import reactor.core.publisher.Mono;

public interface AddressService {

	Mono<AddressResponseRecord> createAddress(AddressRecordCreationRequest addressRecordCreationRequest);
}
