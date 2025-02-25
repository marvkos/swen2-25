package at.technikum.javafx.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

    private final StringProperty searchText
            = new SimpleStringProperty("");

    private final BooleanProperty searchDisabled
            = new SimpleBooleanProperty(true);

    private final ObservableList<String> searchHistory
            = FXCollections.observableArrayList();

    public MainViewModel() {
        searchDisabled.bind(searchText.isEmpty());
    }

    public void search() {
        // add search term to history...
        searchHistory.add(searchText.get());

        // notice: no view.clearSearch()
        searchText.set("");
    }

    public void clearHistory() {
        searchHistory.clear();
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

    public ObservableList<String> getSearchHistory() {
        return searchHistory;
    }
}
