package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.*;

public class Library extends Prototype {
    String name;
    Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library) super.clone();
    }
    
    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book: books) {
            clonedLibrary.getBooks().add(new Book(book.getTitle(),book.getAuthor(),book.getPublicationDate()));
        }return clonedLibrary;
    }

    public void printLibrary() {
        books.stream().forEach(System.out::println);
        System.out.println("\n");
    }
}
