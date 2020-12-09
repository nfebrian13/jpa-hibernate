package com.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thymeleaf.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

}
