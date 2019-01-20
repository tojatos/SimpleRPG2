package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import simplerpg.Character;
import simplerpg.Game;

public class BeforeFightController {
    public ProgressBar characterHpFill;
    public Label characterNameLabel;
    public Label attackPointsLabel;

    private Game getGame() {
        return GameController.Game;
    }

    @FXML
    private void initialize() {
        Character mainCharacter = getGame().mainCharacter;
        characterHpFill.setProgress(mainCharacter.getHealthPoints() / mainCharacter.getMaxHealthPoints());
        Tooltip hpTooltip = new Tooltip();
        hpTooltip.setText(mainCharacter.getHealthPoints() + "/" + mainCharacter.getMaxHealthPoints());
        characterHpFill.setTooltip(hpTooltip);
        characterNameLabel.setText(mainCharacter.getName());
        attackPointsLabel.setText(Integer.toString(mainCharacter.getAttackPoints()));

    }
}
