package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println("Beautifying strings with lambdas by UpperCase");
        poemBeautifier.beautify("Butterfly", (someString) -> someString.toUpperCase());
        System.out.println("Beautifying strings with lambdas by adding some text");
        poemBeautifier.beautify("Butterfly", (someString) -> "BEGINING: " + someString + " :THE END");
        System.out.println("Beautifying strings with lambdas by UpperCase");
        poemBeautifier.beautify("Butterfly", (someString) -> someString.length() + " it's our " + someString + " string length");
        System.out.println("Beautifying strings with lambdas by lower casing");
        poemBeautifier.beautify("SOME FLOWER BLOOMS OVER OUR HEADS ", (someString) -> someString.toLowerCase()+ " before decorated: "  + someString);
    }
}
