package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.entity.Address;
import com.springboot.repository.AddressRepository;

public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public void save(Address address) {
		addressRepository.save(address);
	}
}
