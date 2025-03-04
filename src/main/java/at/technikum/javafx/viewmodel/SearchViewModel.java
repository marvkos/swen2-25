package at.technikum.javafx.viewmodel;

import at.technikum.javafx.service.SearchTermService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchViewModel {

    private final SearchTermService searchTermService;

    private final StringProperty searchText
            = new SimpleStringProperty("");

    private final BooleanProperty searchDisabled
            = new SimpleBooleanProperty(true);

    public SearchViewModel(SearchTermService searchTermService) {
        this.searchTermService = searchTermService;

        this.searchDisabled.bind(searchText.isEmpty());
    }

    public void search() {
        this.searchTermService.add(searchText.get());

        // notice: no view.clearSearch()
        searchText.set("");
    }

    public String getSearchText() {
        return searchText.get();
    }

    public StringProperty searchTextProperty() {
        return searchText;
    }

    public boolean isSearchDisabled() {
        return searchDisabled.get();
    }

    public BooleanProperty searchDisabledProperty() {
        return searchDisabled;
    }
}
