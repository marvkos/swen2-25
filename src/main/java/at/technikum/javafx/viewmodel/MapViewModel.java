package at.technikum.javafx.viewmodel;

import at.technikum.javafx.entity.Geocode;
import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.event.Events;
import at.technikum.javafx.service.SearchTermService;
import javafx.scene.web.WebEngine;

public class MapViewModel {

    private WebEngine webEngine;

    private final EventManager eventManager;

    private final SearchTermService searchTermService;

    public MapViewModel(EventManager eventManager, SearchTermService searchTermService) {
        this.eventManager = eventManager;
        this.searchTermService = searchTermService;

        this.eventManager.subscribe(
                Events.SEARCH_TERMS_CHANGED, this::onSearchTerm
        );
    }

    public void init() {
        String html = getClass()
                .getResource("/at/technikum/javafx/map.html").toExternalForm();
        this.webEngine.load(html);
    }

    private void onSearchTerm(String message) {
        Geocode geocode = searchTermService.getRecentSearch();
        if (null == geocode) {
            return;
        }

        webEngine.executeScript(
                String.format("map.setView([%s, %s], 13);", geocode.getLatitude(), geocode.getLongitude())
        );
    }

    public void setWebEngine(WebEngine webEngine) {
        this.webEngine = webEngine;
    }
}
