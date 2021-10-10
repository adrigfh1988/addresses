package org.justonemore.service.service;

import org.justonemore.persistence.entity.Address;
import org.justonemore.persistence.repository.AddressRepository;
import org.justonemore.service.AddressService;
import org.justonemore.service.component.AddressMapper;
import org.justonemore.service.dto.AddressRecordCreationRequest;
import org.justonemore.service.dto.AddressResponseRecord;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

	private final AddressRepository addressRepository;

	private final AddressMapper addressMapper;

	public AddressServiceImpl(AddressRepository addressRepository, AddressMapper addressMapper) {
		this.addressRepository = addressRepository;
		this.addressMapper = addressMapper;
	}

	@Override
	public Mono<AddressResponseRecord> createAddress(AddressRecordCreationRequest addressRecordCreationRequest) {

		return Mono.from(addressRepository.findBy(PageRequest.of(1, 1, Sort.by("id").descending())))
				.map((Address maxIdValue) -> {
					Integer id = maxIdValue.id();
					return addressMapper.mapRequestToEntity(addressRecordCreationRequest, ++id);
				}).switchIfEmpty(Mono.just(addressMapper.mapRequestToEntity(addressRecordCreationRequest, 1)))
				.flatMap(addressRepository::save).map(addressMapper::mapEntityToResponse);
	}

}
