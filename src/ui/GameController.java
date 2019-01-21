package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import simplerpg.Character;
import simplerpg.CharacterClass;
import simplerpg.Game;

import java.io.IOException;

public class GameController {

    public static simplerpg.Game Game;
    public TextField playerNameField;
    public Label inputInfoLabel;
    public Button paladinButton;
    public Button warriorButton;
    public Button berserkButton;

    private String characterName;

    @FXML
    private void initialize() {
        paladinButton.setOnAction(event -> startGame(characterName, CharacterClass.Paladin));
        warriorButton.setOnAction(event -> startGame(characterName, CharacterClass.Warrior));
        berserkButton.setOnAction(event -> startGame(characterName, CharacterClass.Berserk));
    }

    public void setCharacterName(KeyEvent keyEvent) {
        if(keyEvent.getCode() != KeyCode.ENTER) return;
        String name = playerNameField.getText();
        if(name.trim().isEmpty()) return;

        characterName = name;
        playerNameField.setVisible(false);
        inputInfoLabel.setText("You are a:");
        paladinButton.setVisible(true);
        warriorButton.setVisible(true);
        berserkButton.setVisible(true);
    }

    private void startGame(String characterName, CharacterClass characterClass) {
        Character mainCharacter = simplerpg.Character.createCharacter(characterClass, characterName);
        Game = new Game(mainCharacter);
        SceneManager.loadScene(SceneManager.Scenes.BeforeFight);
    }


}
