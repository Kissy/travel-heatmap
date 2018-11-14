package fr.kissy;

import com.google.gson.Gson;
import com.google.maps.errors.ApiException;
import fr.kissy.model.City;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/**
 * Created by guillaume on 16/08/2017.
 */
public class ConvertToJson {
    public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        final String dataFileName = "city-data.properties";

        Properties data = new Properties();
        if (Paths.get(dataFileName).toFile().exists()) {
            try (InputStream is = new FileInputStream(dataFileName)) {
                data.load(is);
            }
        }

        ArrayList<Object> cities = new ArrayList<>();
        for (Map.Entry<Object, Object> cityEntry : data.entrySet()) {
            cities.add(new City((String) cityEntry.getValue()));
        }

        try (OutputStream os = new FileOutputStream("city-data.json")) {
            os.write(new Gson().toJson(cities).getBytes(StandardCharsets.UTF_8));
        }
    }
}
