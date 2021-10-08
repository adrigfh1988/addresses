package service;

import dto.AddressRecordCreationRequest;
import dto.AddressResponseRecord;
import repository.AddressRepository;

import org.springframework.stereotype.Service;

@Service
public class AddressService {

	private final AddressRepository addressRepository;

	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	public AddressResponseRecord createAddress(AddressRecordCreationRequest addressRecordCreationRequest){

		return null;

	}

}
