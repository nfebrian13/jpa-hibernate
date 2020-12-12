package com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import com.springboot.entity.Book;
import com.springboot.entity.Page;

@Repository
public interface PageRepository extends CrudRepository<Page, Long> {

	List<Page> findByBook(Book book, Sort sort);

}
