package org.justonemore.address_service.service;

import org.justonemore.address_service.component.AddressMapper;
import org.justonemore.address_service.dto.AddressRecordCreationRequest;
import org.justonemore.address_service.dto.AddressResponseRecord;
import org.justonemore.persistence.repository.AddressRepository;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@ComponentScan("org.justonemore")
@Service
public class AddressService {

	private final AddressRepository addressRepository;

	private final AddressMapper addressMapper;

	public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	public Mono<AddressResponseRecord> createAddress(AddressRecordCreationRequest addressRecordCreationRequest) {

		// return addressRepository.findTopById()
		// .map((Integer maxIdValue) ->
		// addressMapper.mapRequestToEntity(addressRecordCreationRequest,
		// ++maxIdValue))
		// .switchIfEmpty(Mono.just(addressMapper.mapRequestToEntity(addressRecordCreationRequest,
		// 1)))
		// .flatMap(addressRepository::save).map(addressMapper::mapEntityToResponse);
		return Mono.empty();
	}

}
