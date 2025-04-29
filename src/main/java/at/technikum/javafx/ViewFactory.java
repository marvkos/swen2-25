package at.technikum.javafx;

import at.technikum.javafx.event.EventManager;
import at.technikum.javafx.repository.SearchTermRepository;
import at.technikum.javafx.repository.SearchTermRepositoryOrm;
import at.technikum.javafx.service.*;
import at.technikum.javafx.view.*;
import at.technikum.javafx.viewmodel.*;

public class ViewFactory {

    private static ViewFactory instance;

    private final ConfigManager configManager;

    private final EventManager eventManager;

    private final SearchTermRepository searchTermRepository;

    private final MapService mapService;

    private final SearchTermService searchTermService;

    private final ExporterService exporterService;

    private ViewFactory() {
        this.configManager = new ConfigManager();
        this.eventManager = new EventManager();
        this.searchTermRepository = new SearchTermRepositoryOrm();
        this.mapService = new OpenRouteServiceApi(this.configManager);
        this.exporterService = new ExporterService();
        this.searchTermService = new SearchTermService(eventManager, mapService, searchTermRepository);
    }

    public static ViewFactory getInstance() {
        if (null == instance) {
            instance = new ViewFactory();
        }

        return instance;
    }

    public Object create(Class<?> viewClass) {
        if (MainView.class == viewClass) {
            return new MainView(new MainViewModel());
        }

        if (MenuView.class == viewClass) {
            return new MenuView(new MenuViewModel(eventManager, searchTermService));
        }

        if (SearchView.class == viewClass) {
            return new SearchView(
                    new SearchViewModel(
                            eventManager,
                            searchTermService
                    )
            );
        }

        if (HistoryView.class == viewClass) {
            return new HistoryView(
                    new HistoryViewModel(
                            eventManager,
                            searchTermService
                    )
            );
        }

        if (MapView.class == viewClass) {
            return new MapView(
                    new MapViewModel(
                            eventManager,
                            searchTermService,
                            exporterService
                    )
            );
        }

        throw new IllegalArgumentException(
                "Unknown view class: " + viewClass
        );
    }
}
