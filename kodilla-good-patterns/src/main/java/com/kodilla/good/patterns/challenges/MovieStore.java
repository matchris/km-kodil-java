package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MovieStore {

    public Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        List<String> deadEvilTranslations = new ArrayList<>();
        deadEvilTranslations.add("Martwe Zło");
        deadEvilTranslations.add("Dead Evil");

        List<String> smallEvilTranslations = new ArrayList<>();
        deadEvilTranslations.add("Małe Zło");
        deadEvilTranslations.add("Small Evil");

        List<String> findingNemoTranslation = new ArrayList<>();
        findingNemoTranslation.add("W poszukiwaniu Nemo");
        findingNemoTranslation.add("Finding Nemo");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);
        booksTitlesWithTranslations.put("LD", deadEvilTranslations);
        booksTitlesWithTranslations.put("FN",findingNemoTranslation);
        booksTitlesWithTranslations.put("SE",smallEvilTranslations);

        return booksTitlesWithTranslations;
    }
}