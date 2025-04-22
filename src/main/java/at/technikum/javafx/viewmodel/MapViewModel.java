package at.technikum.javafx.viewmodel;

import at.technikum.javafx.entity.Geocode;
import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.event.Events;
import at.technikum.javafx.provider.SnapshotProvider;
import at.technikum.javafx.service.ExporterService;
import at.technikum.javafx.service.SearchTermService;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.web.WebEngine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class MapViewModel {

    private WebEngine webEngine;

    private SnapshotProvider snapshotProvider;

    private final EventManager eventManager;

    private final SearchTermService searchTermService;

    private final ExporterService exporterService;

    public MapViewModel(
            EventManager eventManager,
            SearchTermService searchTermService,
            ExporterService exporterService
    ) {
        this.eventManager = eventManager;
        this.searchTermService = searchTermService;
        this.exporterService = exporterService;

        this.eventManager.subscribe(
                Events.SEARCH_TERMS_CHANGED, this::onSearchTerm
        );
        this.eventManager.subscribe(
                Events.MAP_EXPORT_CLICKED, this::onMapExport
        );
    }

    public void init() {
        String html = getClass()
                .getResource("/at/technikum/javafx/map.html").toExternalForm();
        this.webEngine.load(html);
    }

    private void onSearchTerm(String message) {
        Geocode geocode = searchTermService.getRecentSearch();
        if (null == geocode) {
            return;
        }

        webEngine.executeScript(
                String.format("map.setView([%s, %s], 13);", geocode.getLatitude(), geocode.getLongitude())
        );
    }

    private void onMapExport(String message) {
        snapshotProvider.requestSnapshot(writableImage -> {
            BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
            exporterService.export(bufferedImage, "test");
        });
    }

    public void setWebEngine(WebEngine webEngine) {
        this.webEngine = webEngine;
    }

    public void setSnapshotProvider(SnapshotProvider snapshotProvider) {
        this.snapshotProvider = snapshotProvider;
    }
}
