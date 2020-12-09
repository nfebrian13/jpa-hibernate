package com.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.thymeleaf.entity.Address;
import com.thymeleaf.repository.AddressRepository;

public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public void save(Address address) {
		addressRepository.save(address);
	}
}
