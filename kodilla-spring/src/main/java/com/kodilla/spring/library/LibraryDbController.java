package com.kodilla.spring.library;

import org.springframework.stereotype.Repository;

@Repository
public class LibraryDbController {
    void saveData(){
        System.out.println("Saving data into the base");
    }

    void loadData(){
        System.out.println("Loading data from the base");
    }
}
