package com.registration.app.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.registration.app.model.Member;

public interface MemberDao extends PagingAndSortingRepository<Member, String>{

}
