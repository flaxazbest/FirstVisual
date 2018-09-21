package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Random;

public class MainController {

    @FXML
    Button pressMeButton1;

    @FXML
    TextField text;

    Random generator = new Random();

    public void press(ActionEvent actionEvent) {
        ((Button)(actionEvent.getSource())).setText("Hello " + text.getText());
    }
}
