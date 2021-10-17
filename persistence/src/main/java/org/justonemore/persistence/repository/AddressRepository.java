package org.justonemore.persistence.repository;

import org.justonemore.persistence.entity.Address;
import reactor.core.publisher.Mono;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ReactiveCrudRepository<Address, Integer> {

	Mono<Boolean> existsAddressByPersonIdentifierAndCityAndCountryAndPostalCodeAndProvinceAndStreetName(
			String personIdentifier, String city, String country, String postalCode, String province,
			String streetName);

}
