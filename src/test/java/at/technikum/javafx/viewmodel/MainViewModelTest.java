package at.technikum.javafx.viewmodel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainViewModelTest {

    @Test
    void give_search_when_inputEmpty_then_buttonDisabled() {
        // Arrange
        MainViewModel viewModel = new MainViewModel();

        // Act
        viewModel.searchTextProperty().set("");

        // Assert
        assertTrue(viewModel.isSearchDisabled());
    }

    @Test
    void give_search_when_inputNotEmpty_then_buttonEnabled() {
        // Arrange
        MainViewModel viewModel = new MainViewModel();

        // Act
        viewModel.searchTextProperty().set("test search");

        // Assert
        assertFalse(viewModel.isSearchDisabled());
    }
  
}
