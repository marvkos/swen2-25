package at.technikum.javafx.service;

import at.technikum.javafx.entity.Geocode;
import at.technikum.javafx.entity.SearchTerm;
import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.event.Events;
import at.technikum.javafx.repository.SearchTermRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class SearchTermService {

    private final EventManager eventManager;

    private final MapService mapService;

    private final SearchTermRepository searchTermRepository;

    private Geocode recentSearch;

    public SearchTermService(
            EventManager eventManager,
            MapService mapService,
            SearchTermRepository searchTermRepository
    ) {
        this.eventManager = eventManager;
        this.mapService = mapService;
        this.searchTermRepository = searchTermRepository;
    }

    public void add(String term) {
        SearchTerm searchTerm = new SearchTerm();
        searchTerm.setId(UUID.randomUUID().toString());
        searchTerm.setTerm(term);
        searchTerm.setFirstSearched(LocalDateTime.now());

        this.mapService.findGeocode(term)
                .ifPresent(searchTerm::setGeocode);
        this.recentSearch = searchTerm.getGeocode();

        this.searchTermRepository.save(searchTerm);

        eventManager.publish(Events.SEARCH_TERMS_CHANGED, "NEW");
    }

    public void clearSearchTerms() {
        this.searchTermRepository.deleteAll();

        eventManager.publish(Events.SEARCH_TERMS_CHANGED, "CLEAR");
    }

    public List<String> getSearchTerms() {
        return this.searchTermRepository
                .findAll().stream()
                .map(SearchTerm::getTerm)
                .toList();
    }

    public Geocode getRecentSearch() {
        return recentSearch;
    }
}
