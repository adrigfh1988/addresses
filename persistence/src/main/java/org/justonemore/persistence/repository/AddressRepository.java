package org.justonemore.persistence.repository;

import org.justonemore.persistence.entity.Address;
import reactor.core.publisher.Flux;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends ReactiveCrudRepository<Address, Integer> {

	Flux<Address> findBy(Pageable pageable);

}
