package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given



        Book book1 = new Book("Title1", "Author1", LocalDate.ofYearDay(2000, 12));
        Book book2 = new Book("Title2", "Author2", LocalDate.ofYearDay(2001, 12));
        Book book3 = new Book("Title3", "Author3", LocalDate.ofYearDay(2002, 12));
        Book book4 = new Book("Title4", "Author4", LocalDate.ofYearDay(2003, 12));
        Book book5 = new Book("Title5", "Author5", LocalDate.ofYearDay(2004, 12));

        Library library = new Library("Library 1");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);




        //Shallow copy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        library.printLibrary();
        clonedLibrary.printLibrary();

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        //Then
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals("Library 1", library.getName());

        clonedLibrary.getBooks().remove(book1);
        clonedLibrary.printLibrary();

        Assert.assertEquals(4,clonedLibrary.getBooks().size());
        Assert.assertEquals(library.getBooks().size(),clonedLibrary.getBooks().size());
        Assert.assertNotEquals(deepClonedLibrary.getBooks().size(),library.getBooks().size());
    }
}
