package at.technikum.javafx.viewmodel;

import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.service.SearchTermService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchViewModelTest {

    @Test
    void give_search_when_inputEmpty_then_buttonDisabled() {
        // Arrange
        SearchViewModel viewModel = new SearchViewModel(
                new SearchTermService(new EventManager())
        );

        // Act
        viewModel.searchTextProperty().set("");

        // Assert
        assertTrue(viewModel.isSearchDisabled());
    }

    @Test
    void give_search_when_inputNotEmpty_then_buttonEnabled() {
        // Arrange
        SearchViewModel viewModel = new SearchViewModel(
                new SearchTermService(new EventManager())
        );

        // Act
        viewModel.searchTextProperty().set("test search");

        // Assert
        assertFalse(viewModel.isSearchDisabled());
    }
  
}
