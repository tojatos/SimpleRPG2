package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GameController {

    public TextField playerNameField;
    public Label inputInfoLabel;
    public Button paladinButton;

    private String playerName;

    @FXML
    private void initialize() {
        paladinButton.setOnAction(event -> System.out.println("paladin"));
    }

    public void setPlayerName(KeyEvent keyEvent) {
        if(keyEvent.getCode() != KeyCode.ENTER) return;
        String name = playerNameField.getText();
        if(name.trim().isEmpty()) return;

        playerName = name;
        playerNameField.setVisible(false);
        inputInfoLabel.setText("You are a:");
    }
}
