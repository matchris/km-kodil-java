package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String someString, PoemDecorator poemDecorator){
        String result = poemDecorator.decorate(someString);
        System.out.println("Decorated poem: " + result);
    }
}
