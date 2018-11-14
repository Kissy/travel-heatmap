package fr.kissy;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fr.kissy.model.City;
import fr.kissy.model.Countries;
import fr.kissy.model.Country;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Optional;

public class MapScoresWithGeoJson {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<City>>() {
        }.getType();
        ArrayList<City> cities = gson.fromJson(new FileReader("src/main/webapps/city-data.json"), listType);
        Countries countries = gson.fromJson(new FileReader("src/main/resources/countries.geo.json"), Countries.class);

        for (City city : cities) {
            Optional<Country> foundCountry = countries.getFeatures().stream()
                    .filter(c -> c.getProperties().getName().equals(city.getCountry()))
                    .findFirst();

            foundCountry.ifPresent(country -> country.getProperties().addCity(city));
        }

        try (FileWriter writer = new FileWriter("countries-data.geo.json")) {
            writer.write(gson.toJson(countries));
        }
    }
}
