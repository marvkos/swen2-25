package at.technikum.javafx.view;

import at.technikum.javafx.viewmodel.MapViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.WritableImage;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MapView implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger();

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

        LOGGER.info("Map View initialized.");
    }

    private void onSnapShot(Consumer<WritableImage> writableImageConsumer) {
        writableImageConsumer
                .accept(webViewMap.snapshot(null, null));
    }

}
