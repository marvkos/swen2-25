package at.technikum.javafx.viewmodel;

import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.event.Events;
import at.technikum.javafx.service.SearchTermService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HistoryViewModel {

    private final EventManager eventManager;

    private final SearchTermService searchTermService;

    private final ObservableList<String> searchHistory
            = FXCollections.observableArrayList();

    public HistoryViewModel(
            EventManager eventManager,
            SearchTermService searchTermService
    ) {
        this.eventManager = eventManager;
        this.searchTermService = searchTermService;

        this.eventManager.subscribe(
                Events.SEARCH_TERMS_CHANGED, this::onSearchTermChanged
        );
    }

    private void onSearchTermChanged(String message) {
        this.searchHistory.clear();
        this.searchHistory.addAll(searchTermService.getSearchTerms());
    }

    public ObservableList<String> getSearchHistory() {
        return searchHistory;
    }
}
