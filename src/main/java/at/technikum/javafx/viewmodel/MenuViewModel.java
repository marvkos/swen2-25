package at.technikum.javafx.viewmodel;

import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.event.Events;
import at.technikum.javafx.service.SearchTermService;

public class MenuViewModel {

    private final EventManager eventManager;

    private final SearchTermService searchTermService;

    public MenuViewModel(EventManager eventManager, SearchTermService searchTermService) {
        this.eventManager = eventManager;
        this.searchTermService = searchTermService;
    }

    public void clearHistory() {
        searchTermService.clearSearchTerms();
    }

    public void exportMap() {
        this.eventManager.publish(Events.MAP_EXPORT_CLICKED, "MAP");
    }
}
