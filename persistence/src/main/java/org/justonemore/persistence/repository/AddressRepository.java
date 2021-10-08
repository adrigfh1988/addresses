package org.justonemore.persistence.repository;

import org.justonemore.persistence.entity.Address;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AddressRepository extends ReactiveCrudRepository<Address, Integer> {

//	Mono<Integer> findTopById();

}
