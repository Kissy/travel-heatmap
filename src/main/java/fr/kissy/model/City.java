package fr.kissy.model;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by guillaume on 07/08/2017.
 */
public class City {
    private final Integer[] score;
    private String name;
    private Double lat = 0d;
    private Double lon = 0d;
    private String country;
    private String city;

    public City(String propertyString) {
        String[] split = propertyString.split("\\|");
        this.name = split[0];
        this.lat = Double.valueOf(split[1]);
        this.lon = Double.valueOf(split[2]);
        this.score = new Integer[12];
        for (int i = 0; i < 12; i++) {
            this.score[i] = Integer.valueOf(split[i + 3]);
        }
        if (split.length > 16) {
            this.country = split[15];
            this.city = split[16];
        }
    }

    public City(String country, String city) {
        this.name = city + ", " + country;
        this.score = new Integer[12];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer[] getScore() {
        return score;
    }

    public String toPropertyString() {
        String scoreString = Arrays.stream(score).map(Object::toString).collect(Collectors.joining("|"));
        return this.name + "|" + this.lat + "|" + this.lon + "|" + scoreString + "|" + country + "|" + city;
    }

    @Override
    public String toString() {
        return "City{" +
                "score=" + Arrays.toString(score) +
                ", name='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
