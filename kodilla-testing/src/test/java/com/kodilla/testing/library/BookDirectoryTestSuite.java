package com.kodilla.testing.library;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title" + n, "Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {


        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        Assert.assertEquals(4, theListOfBooks.size()); // w theListOfBooks mamy tylko jedną pozycję która dodatkowo nie spełnia secret
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);  //ten kod i poniższy możemy dodać do adnotacji before
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultOf0Books = new ArrayList<>();
        List<Book> resultOf15Books = generateListOfBooks(15);
        List<Book> resultOf40Books = generateListOfBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        Assert.assertEquals(0, theListOfBooks0.size());
        Assert.assertEquals(15, theListOfBooks15.size());
        Assert.assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultOf10Books = generateListOfBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultOf10Books);

        //When
        List<Book> expectedList = bookLibrary.listBooksWithCondition("An");

        //Then
        Assert.assertEquals(0, expectedList.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBookInHandsOf() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser1 = new LibraryUser("John", "Smith", "82348922234");
        LibraryUser libraryUser2 = new LibraryUser("Johan", "Timothy", "89348921565");
        LibraryUser libraryUser3 = new LibraryUser("Janette", "Thunder", "99348923563");
        List<Book> listBookInHandsOf0 = new ArrayList<>();
        List<Book> listBookInHandsOf1 = generateListOfBooks(1);
        List<Book> listBookInHandsOf5 = generateListOfBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1)).thenReturn(listBookInHandsOf0);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2)).thenReturn(listBookInHandsOf1);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser3)).thenReturn(listBookInHandsOf5);

        //When
        List<Book> expectedListOfHandsOf0 = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> expectedListOfHandsOf1 = bookLibrary.listBooksInHandsOf(libraryUser2);
        List<Book> expectedListOfHandsOf5 = bookLibrary.listBooksInHandsOf(libraryUser3);

        //Then
        assertEquals(0, expectedListOfHandsOf0.size());
        assertEquals(1, expectedListOfHandsOf1.size());
        assertEquals(5, expectedListOfHandsOf5.size());
    }
}
