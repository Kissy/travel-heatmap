package fr.kissy.model;

import java.util.ArrayList;
import java.util.List;

public class CountryProperties {
    private String name;
    private final Integer[] score = new Integer[12];
    private final List<City> cities = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void addCity(City city) {
        cities.add(city);
        calculateScores();
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer[] getScore() {
        return score;
    }

    private void calculateScores() {
        for (int i = 0; i < 12; i++) {
            int scoreIndex = i;
            double average = getCities().stream()
                    .mapToInt(city -> city.getScore()[scoreIndex])
                    .average()
                    .orElse(0);
            score[scoreIndex] = Math.toIntExact(Math.round(average));
        }
    }
}
