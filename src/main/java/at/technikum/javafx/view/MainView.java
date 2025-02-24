package at.technikum.javafx.view;

import at.technikum.javafx.viewmodel.MainViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements Initializable {

    private MainViewModel viewModel = new MainViewModel();

    @FXML
    private TextField searchInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchInput.textProperty()
                .bindBidirectional(viewModel.searchTextProperty());
    }

    @FXML
    public void onSearch() {
        viewModel.search();
    }

}
