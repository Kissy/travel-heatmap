package fr.kissy.model;

import com.google.gson.JsonObject;

public class Country {
    public final String type = "Feature";
    private String id;
    private CountryProperties properties;
    private JsonObject geometry;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CountryProperties getProperties() {
        return properties;
    }

    public void setProperties(CountryProperties properties) {
        this.properties = properties;
    }

    public JsonObject getGeometry() {
        return geometry;
    }

    public void setGeometry(JsonObject geometry) {
        this.geometry = geometry;
    }
}
