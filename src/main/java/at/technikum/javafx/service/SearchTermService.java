package at.technikum.javafx.service;

import at.technikum.javafx.event.EventListener;
import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.event.Events;

import java.util.ArrayList;
import java.util.List;

public class SearchTermService {

    private final EventManager eventManager;

    private final List<String> searchTerms;

    public SearchTermService(EventManager eventManager) {
        this.eventManager = eventManager;
        this.searchTerms = new ArrayList<>();
    }

    public void add(String searchTerm) {
        this.searchTerms.add(searchTerm);

        eventManager.publish(Events.SEARCH_TERMS_CHANGED, "NEW");
    }

    public void clearSearchTerms() {
        this.searchTerms.clear();

        eventManager.publish(Events.SEARCH_TERMS_CHANGED, "CLEAR");
    }

    public List<String> getSearchTerms() {
        return searchTerms;
    }
}
