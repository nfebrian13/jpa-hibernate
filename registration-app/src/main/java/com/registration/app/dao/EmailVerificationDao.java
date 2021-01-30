package com.registration.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.registration.app.model.EmailVerification;

public interface EmailVerificationDao extends PagingAndSortingRepository<EmailVerification, String>{

	EmailVerification findByToken(String token);

}
