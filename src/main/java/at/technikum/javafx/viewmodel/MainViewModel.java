package at.technikum.javafx.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MainViewModel {

    private StringProperty searchText
            = new SimpleStringProperty("");

    public void search() {
        // add search term to history...

        // notice: no view.clearSearch()
        searchText.set("");
    }

    public String getSearchText() {
        return searchText.get();
    }

    public StringProperty searchTextProperty() {
        return searchText;
    }
}
