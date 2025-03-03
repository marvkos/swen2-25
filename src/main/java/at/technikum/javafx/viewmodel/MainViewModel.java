package at.technikum.javafx.viewmodel;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainViewModel {

    private final ObservableList<String> searchHistory
            = FXCollections.observableArrayList();

    public MainViewModel() {

    }

    public void clearHistory() {
        searchHistory.clear();
    }

    public ObservableList<String> getSearchHistory() {
        return searchHistory;
    }
}
