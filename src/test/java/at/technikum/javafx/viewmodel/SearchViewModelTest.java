package at.technikum.javafx.viewmodel;

import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.service.SearchTermService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SearchViewModelTest {

    @Mock
    private EventManager eventManager;

    @Mock
    private SearchTermService searchTermService;

    @Test
    void give_search_when_inputEmpty_then_buttonDisabled() {
        // Arrange
        SearchViewModel viewModel = new SearchViewModel(
                eventManager, searchTermService
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
                eventManager, searchTermService
        );

        // Act
        viewModel.searchTextProperty().set("test search");

        // Assert
        assertFalse(viewModel.isSearchDisabled());
    }
  
}
