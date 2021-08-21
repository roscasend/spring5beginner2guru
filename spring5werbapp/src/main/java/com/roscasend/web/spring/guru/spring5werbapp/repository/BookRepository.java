package com.roscasend.web.spring.guru.spring5werbapp.repository;

import com.roscasend.web.spring.guru.spring5werbapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
