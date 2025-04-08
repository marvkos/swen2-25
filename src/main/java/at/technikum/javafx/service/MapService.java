package at.technikum.javafx.service;

import at.technikum.javafx.entity.Geocode;

import java.util.Optional;

public interface MapService {

    Optional<Geocode> findGeocode(String text);
}
