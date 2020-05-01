package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class MovieStoreIteration {
    static String getMovieTitles() {
        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> bookTitlesWithTranslations = movieStore.getMovies();
        return bookTitlesWithTranslations.entrySet().stream()
                .map(booksTitles -> booksTitles.getValue())
                .flatMap(bookTitles -> bookTitles.stream())
                .collect(Collectors.joining(" ! "));
    }
}


