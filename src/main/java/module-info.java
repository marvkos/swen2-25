module at.technikum.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.technikum.javafx to javafx.fxml;
    exports at.technikum.javafx;
    exports at.technikum.javafx.view;
    opens at.technikum.javafx.view to javafx.fxml;
}
