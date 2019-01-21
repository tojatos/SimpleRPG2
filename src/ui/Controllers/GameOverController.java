package ui.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.SceneManager;

public class GameOverController {

    public Label infoLabel;
    public Label monstersKilledLabel;
    public Button replayButton;

    @FXML
    private void initialize() {
        replayButton.setOnAction(e -> SceneManager.loadScene(SceneManager.Scenes.Main));
        String gameOverText = GameController.Game.mainCharacter.isAlive() ? "Congratulations! You won!" : "You were defeated...";
        infoLabel.setText(gameOverText);
        monstersKilledLabel.setText("Killed monsters: " + GameController.Game.mainCharacter.killedMonsters);


    }
}
