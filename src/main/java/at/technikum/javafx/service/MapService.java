package at.technikum.javafx.service;

import at.technikum.javafx.dto.Geocode;

import java.util.Optional;

public interface MapService {

    Optional<Geocode> findGeocode(String text);
}
