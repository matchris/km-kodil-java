package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Czarnecki", "Skąd i z nikąd", 1999, "ISBN9938"));
        bookSet.add(new Book("Wybicki", "Dokąd zmierzacie", 1900, "ISBN3434"));
        bookSet.add(new Book("Święcicki", "Minąłem was w ciszy", 1991, "ISBN2323"));
        bookSet.add(new Book("Płomianowska", "Pole rumiankami wypełnione", 1980, "ISBN2222"));

        //When
        int medianEvenElements = medianAdapter.publicationYearMedian(bookSet);
        int medianOddElements = medianEvenElements-1;
        //Then
        assertEquals(1985,medianEvenElements);
        assertEquals(1984,medianOddElements);
    }
}

