package at.technikum.javafx.view;

import at.technikum.javafx.viewmodel.MapViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MapView implements Initializable {

    private final MapViewModel viewModel;

    @FXML
    private WebView webViewMap;

    public MapView(MapViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.viewModel.setWebEngine(webViewMap.getEngine());

        viewModel.init();
    }
}
