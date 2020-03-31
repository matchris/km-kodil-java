package com.kodilla.exception.main;
import java.io.*;
import com.kodilla.exception.io.FileReader;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.readFile();
    }
}
