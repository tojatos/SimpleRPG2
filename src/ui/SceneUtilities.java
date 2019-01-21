package ui;

import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import simplerpg.Fighter;

public final class SceneUtilities {

    public static void updateHpBar(ProgressBar bar, Fighter fighter) {
        bar.setProgress(fighter.getHealthPoints() / (float) fighter.getMaxHealthPoints());
        Tooltip hpTooltip = new Tooltip();
        hpTooltip.setText(fighter.getHealthPoints() + "/" + fighter.getMaxHealthPoints());
        bar.setTooltip(hpTooltip);
    }

}
