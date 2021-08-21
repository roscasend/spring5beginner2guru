package com.roscasend.web.spring.guru.spring5werbapp.bootstrap;

import com.roscasend.web.spring.guru.spring5werbapp.domain.Author;
import com.roscasend.web.spring.guru.spring5werbapp.domain.Book;
import com.roscasend.web.spring.guru.spring5werbapp.domain.Publisher;
import com.roscasend.web.spring.guru.spring5werbapp.repository.AuthorRepository;
import com.roscasend.web.spring.guru.spring5werbapp.repository.BookRepository;
import com.roscasend.web.spring.guru.spring5werbapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData (AuthorRepository authorRepository, BookRepository bookRepository,
                          PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author ericAuthor = new Author("Eric", "Evans");
        Book domainDrivenDesign = new Book("Domain Driven Design", "123123");
        ericAuthor.getBooks().add(domainDrivenDesign);
        domainDrivenDesign.getAuthors().add(ericAuthor);

        authorRepository.save(ericAuthor);
        bookRepository.save(domainDrivenDesign);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "233242342");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books : "+bookRepository.count());

        Publisher publisher = new Publisher("teora", "habar nu am care e adresa");
        publisherRepository.save(publisher);
        System.out.println("Number of publishers : " + publisherRepository.count());
    }
}
