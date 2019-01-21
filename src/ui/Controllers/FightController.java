package ui.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import simplerpg.*;
import simplerpg.Character;
import ui.SceneManager;
import ui.SceneUtilities;

import java.util.Observable;
import java.util.Observer;

public class FightController implements Observer {
    public ProgressBar characterHpBar;
    public ProgressBar monsterHpBar;
    public Label characterNameLabel;
    public Label monsterNameLabel;
    public Button attackButton;

    private Game getGame() {
        return GameController.Game;
    }
    @FXML
    private void initialize() {
        MonsterFight activeFight = getGame().activeFight;
        attackButton.setOnAction(e -> activeFight.attack());
        characterNameLabel.setText(activeFight.character.getName());
        monsterNameLabel.setText(activeFight.monster.getName());
        activeFight.character.addObserver(this);
        activeFight.monster.addObserver(this);
        activeFight.addObserver(this);
        SceneUtilities.updateHpBar(characterHpBar, activeFight.character);
        SceneUtilities.updateHpBar(monsterHpBar, activeFight.monster);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Character) {
            SceneUtilities.updateHpBar(characterHpBar, (Fighter)observable);
        } else if (observable instanceof Monster) {
            SceneUtilities.updateHpBar(monsterHpBar, (Fighter)observable);
        } else if (o instanceof FightResult) {
            FightResult r = ((FightResult) o);
            SceneManager.loadScene(r.isWon ? SceneManager.Scenes.BeforeFight : SceneManager.Scenes.GameOver);

        }

    }
}
