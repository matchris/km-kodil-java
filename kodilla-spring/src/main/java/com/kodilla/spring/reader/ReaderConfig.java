package com.kodilla.spring.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ReaderConfig {
    @Autowired
    @Qualifier("book3")
    Book book;

    @Bean
    public Reader getReader() {
        return new Reader(book);
    }

    @Bean(name = "book1")
    @Scope("prototype")
    public Book getBookOne() {
        return new Book("The book number one");
    }

    @Bean(name = "book2")
    @Scope("prototype")
    @Conditional(IfDayIsOddCondition.class)
    public Book getBookTwo() {
        return new Book("The book number two And the day should be parzysty");
    }

    @Bean(name = "book3")
    @Scope("prototype")
    public Book getBookThree(){
        return new Book("That's experimental tilte of book number three");
    }
}