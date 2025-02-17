module at.technikum.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.technikum.javafx to javafx.fxml;
    exports at.technikum.javafx;
}