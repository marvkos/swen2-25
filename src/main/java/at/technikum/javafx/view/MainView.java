package at.technikum.javafx.view;

import at.technikum.javafx.viewmodel.MainViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements Initializable {

    private final MainViewModel viewModel = new MainViewModel();

    @FXML
    private TextField searchInput;

    @FXML
    private Button searchButton;

    @FXML
    private ListView<String> searchHistoryList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchInput.textProperty()
                .bindBidirectional(viewModel.searchTextProperty());
        searchButton.disableProperty()
                .bind(viewModel.searchDisabledProperty());

        searchHistoryList.setItems(viewModel.getSearchHistory());
    }

    @FXML
    public void onSearch() {
        viewModel.search();
    }

}
