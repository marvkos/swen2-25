package at.technikum.javafx.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainView implements Initializable {

    private int counter = 0;

    @FXML
    private Label welcomeText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setText(String.valueOf(counter));
    }

    @FXML
    protected void onHelloButtonClick() {
        counter++;
        welcomeText.setText(String.valueOf(counter));
    }


}
