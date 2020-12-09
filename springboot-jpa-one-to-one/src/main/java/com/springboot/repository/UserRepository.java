package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

}
