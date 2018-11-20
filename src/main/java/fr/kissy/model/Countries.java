package fr.kissy.model;

import java.util.ArrayList;
import java.util.List;

public class Countries {
    public final String type = "FeatureCollection";
    private final List<Country> features = new ArrayList<>();

    public List<Country> getFeatures() {
        return features;
    }
}
