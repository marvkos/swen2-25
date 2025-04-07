package at.technikum.javafx.service;

import at.technikum.javafx.dto.Geocode;
import at.technikum.javafx.service.openrouteservice.GeocodeSearchResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class OpenRouteServiceApi implements MapService {

    private final static String API_KEY =
            "";

    private final static String GEOCODE_SEARCH_URI =
            "https://api.openrouteservice.org/geocode/search?api_key=%s&text=%s";

    private final HttpClient client;
    private final ObjectMapper objectMapper;

    public OpenRouteServiceApi() {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public Optional<Geocode> findGeocode(String text) {
        String uri = String.format(GEOCODE_SEARCH_URI, API_KEY, text);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString()
            );

            GeocodeSearchResponse geocodeSearchResponse = objectMapper.readValue(
                    response.body(), GeocodeSearchResponse.class
            );

            if (geocodeSearchResponse.getFeatures().isEmpty()) {
                return Optional.empty();
            }

            Geocode geocode = new Geocode();
            geocode.setText(text);
            geocode.setLongitude(geocodeSearchResponse.getFeatures().getFirst().getGeometry().getCoordinates()[0]);
            geocode.setLatitude(geocodeSearchResponse.getFeatures().getFirst().getGeometry().getCoordinates()[1]);

            return Optional.of(geocode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
