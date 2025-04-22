package at.technikum.javafx.view;

import at.technikum.javafx.viewmodel.MapViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.WritableImage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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

        viewModel.setSnapshotProvider(this::onSnapShot);

        viewModel.init();
    }

    private void onSnapShot(Consumer<WritableImage> writableImageConsumer) {
        writableImageConsumer
                .accept(webViewMap.snapshot(null, null));
    }

}
