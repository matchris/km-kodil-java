package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Scope("singleton")
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();

    @Autowired
    private LibraryDbController libraryDbController;

    public Library(){
    }

    public void saveToDb(){
        libraryDbController.saveData();
    }

    public void loadFromDb(){
        libraryDbController.loadData();
    }
}
