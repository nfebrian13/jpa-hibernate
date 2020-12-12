package com.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.entity.Book;
import com.springboot.entity.Page;
import com.springboot.repository.BookRepository;
import com.springboot.repository.PageRepository;

@SpringBootApplication
public class SpringbootJpaOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaOneToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(BookRepository bookRepository, PageRepository pageRepository) {
		return args -> {

			// create a new book
			Book book = new Book("Java 101", "John Doe", "123456");
			Book book2 = new Book("Thymeleaf ", "Nana Febriana", "999999");

			// save the book
			bookRepository.save(book);
			bookRepository.save(book2);

			// create and save new pages
			pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
			pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
			pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));
			
			// create and save new pages
			pageRepository.save(new Page(1, "Intro", "Intro", book2));
			pageRepository.save(new Page(65, "Thymeleaf 8 contents", "Thymeleaf 8", book2));
			pageRepository.save(new Page(95, "Paging contents", "Paging", book2));
		};
	}
}
