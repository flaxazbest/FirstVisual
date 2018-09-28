package logic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    Label label;

    @FXML
    RadioButton radio1;
    @FXML
    RadioButton radio2;
    @FXML
    RadioButton radio3;

    @FXML
    Button button;

    @FXML
    ComboBox<String> comboBox;

    @FXML
    CheckBox checkBox;

    @FXML
    Button pressMeButton1;
    @FXML
    Button pressMeButton2;
    @FXML
    Button pressMeButton3;

    @FXML
    ProgressBar progress;

    @FXML
    ListView<String> listView;

    @FXML
    ChoiceBox<String> choiseBox;

    @FXML
    TextField text;

    ToggleGroup tg = new ToggleGroup();

    Random generator = new Random();

    public void press(ActionEvent actionEvent) {
        ((Button)(actionEvent.getSource())).setText("Hello " + text.getText());
        if (((Button)(actionEvent.getSource())).getId().equals("pressMeButton2")
                &&
                checkBox.isSelected()
                ) {
            choiseBox.getItems().add(text.getText());
        }
        checkBox.setIndeterminate(true);
    }

    public void check(ActionEvent actionEvent) {
        if (checkBox.isSelected()) {
            text.setText("On");
            label.setVisible(true);
        }
        else if (checkBox.isIndeterminate()) {
            checkBox.setSelected(true);
            checkBox.fire();
                    }
        else {
            text.setText("Off");
            label.setVisible(false);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        checkBox.setAllowIndeterminate(true);
        tg.getToggles().addAll(radio1, radio2, radio3);
        pressMeButton1.setDisable(true);
        pressMeButton2.setDisable(true);
        pressMeButton3.setDisable(true);
        radio1.fire();

        choiseBox.getItems().addAll("Mon", "Tue");
        comboBox.getItems().addAll("Mon", "Tue", "Wed", "Thu");
        listView.getItems().addAll("Mon", "Tue", "Wed", "Thu");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }

    public void activate1(ActionEvent actionEvent) {
        pressMeButton1.setDisable(false);
        pressMeButton2.setDisable(true);
        pressMeButton3.setDisable(true);
    }

    public void activate2(ActionEvent actionEvent) {
        pressMeButton2.setDisable(false);
        pressMeButton1.setDisable(true);
        pressMeButton3.setDisable(true);
    }

    public void activate3(ActionEvent actionEvent) {
        pressMeButton3.setDisable(false);
        pressMeButton2.setDisable(true);
        pressMeButton1.setDisable(true);
    }

    public void choise(ActionEvent actionEvent) {
        label.setText(choiseBox.getValue());
    }

    public void combo(ActionEvent actionEvent) {
        //comboBox.getSelectionModel().

    }

    public void printAll(ActionEvent actionEvent) {
        StringBuilder sb = new StringBuilder();
        for (int i=-0; i<listView.getItems().size(); i++) {
            if (listView.getSelectionModel().isSelected(i)) {
                sb.append(listView.getItems().get(i));
                sb.append(" ");
            }
        }
        text.setText(sb.toString());
    }

    public void selectMaybe(MouseEvent mouseEvent) {
        int count = 0;
        for (int i=-0; i<listView.getItems().size(); i++) {
            if (listView.getSelectionModel().isSelected(i)) {
                count++;
            }
        }
        double percents = ((double)count / listView.getItems().size());
        progress.setProgress(percents);
    }
}
