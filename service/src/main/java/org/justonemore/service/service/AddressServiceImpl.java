package org.justonemore.service.service;

import org.justonemore.persistence.entity.Address;
import org.justonemore.persistence.repository.AddressRepository;
import org.justonemore.service.AddressService;
import org.justonemore.service.component.AddressMapper;
import org.justonemore.service.dto.AddressRecordCreationRequest;
import org.justonemore.service.dto.AddressResponseRecord;
import reactor.core.publisher.Mono;

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

		Address address = addressMapper.mapRequestToEntity(addressRecordCreationRequest, null);

		return isAddressValidToSave(address).doOnError(Mono::error).filter(Boolean::booleanValue)
				.map(aBoolean -> address).flatMap((Address addressToSave) -> addressRepository.save(address))
				.map(addressMapper::mapEntityToResponse);

	}

	private Mono<Boolean> isAddressValidToSave(Address address) {

		return addressRepository.existsAddressByPersonIdentifierAndCityAndCountryAndPostalCodeAndProvinceAndStreetName(
				address.personIdentifier(), address.city(), address.country(), address.postalCode(), address.province(),
				address.streetName()).map(addressAlreadyExists -> {
					if (Boolean.TRUE.equals(addressAlreadyExists)) {
						throw new IllegalArgumentException("ADDRESS DUPLICATED");
					}
					return true;
				});
	}

}
