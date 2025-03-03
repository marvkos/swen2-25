package at.technikum.javafx;

import at.technikum.javafx.view.MainView;
import at.technikum.javafx.view.SearchView;
import at.technikum.javafx.viewmodel.MainViewModel;
import at.technikum.javafx.viewmodel.SearchViewModel;

public class ViewFactory {

    private static ViewFactory instance;

    private ViewFactory() {

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

        if (SearchView.class == viewClass) {
            return new SearchView(new SearchViewModel());
        }

        throw new IllegalArgumentException(
                "Unknown view class: " + viewClass
        );
    }
}
