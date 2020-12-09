package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
