package com.roscasend.web.spring.guru.spring5werbapp.repository;

import com.roscasend.web.spring.guru.spring5werbapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
