package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import simplerpg.Character;
import simplerpg.*;

import java.util.Observable;
import java.util.Observer;

public class BeforeFightController implements Observer {
    public ProgressBar characterHpFill;
    public Label characterNameLabel;
    public Label attackPointsLabel;
    public Label goldLabel;
    public Button smallHpPotButton;
    public Button mediumHpPotButton;
    public Button bigHpPotButton;
    public Button woodenSwordButton;
    public Button silverSwordButton;
    public Button diamondSwordButton;
    public Button leatherArmourButton;
    public Button silverArmourButton;
    public Button dragonSkinButton;
    public Button fightButton;
    public Label newMonsterLabel;
    public ImageView attackMethodImage;
    public ImageView defenseMethodImage;


    private Game getGame() {
        return GameController.Game;
    }

    @FXML
    private void initialize() {

        updateUI();
        addBuyListeners();
        fightButton.setOnAction(e -> startFight());

        getGame().mainCharacter.addObserver(this);
        getGame().monsters.forEach(m -> m.addObserver(this));
    }

    public void updateUI(){
        Character m = getGame().mainCharacter;
        updateHpFill(m);
        updateGold();
        characterNameLabel.setText(m.getName());
        attackPointsLabel.setText(Integer.toString(m.getAttackPoints()));
        String nextMonsterText = getGame().monsters.size() != 0 ? "Next monster: " + getGame().monsters.peek().getName() : "Next monster: ???";
        newMonsterLabel.setText(nextMonsterText);
        setTooltip(attackMethodImage, m.getAttackMethod().getDescription());
        setTooltip(defenseMethodImage, m.getDefenseMethod().getDescription());
    }
    private void setTooltip(ImageView image, String tooltipMessage) {
        Tooltip t = new Tooltip();
        t.setText(tooltipMessage);
        Tooltip.install(image, t);

    }

    public void startFight(){
        MonsterFight fight = getGame().fight();
        if(fight == null) loadGameWonScene();
        fight.addObserver(this);
        loadFightScene();
    }

    private void loadFightScene() {
    }

    private void loadGameWonScene() {
    }

    private void addBuyListeners() {
        Character m = getGame().mainCharacter;
        addBuyListener(smallHpPotButton,   Item.SmallHPPotion,   m);
        addBuyListener(mediumHpPotButton,  Item.MediumHPPotion,  m);
        addBuyListener(bigHpPotButton,     Item.BigHPPotion,     m);
        addBuyListener(woodenSwordButton,         Item.WoodenSword,     m);
        addBuyListener(silverSwordButton,         Item.SilverSword,     m);
        addBuyListener(diamondSwordButton,        Item.DiamondSword,    m);
        addBuyListener(leatherArmourButton,       Item.LeatherArmour,   m);
        addBuyListener(silverArmourButton,        Item.SilverArmour,    m);
        addBuyListener(dragonSkinButton,          Item.DragonSkin,      m);
    }

    private void updateGold() {
        goldLabel.setText("Gold: " + getGame().mainCharacter.getGold());
    }
    private void updateHpFill(Character mainCharacter) {
        characterHpFill.setProgress(mainCharacter.getHealthPoints() / (float) mainCharacter.getMaxHealthPoints());
        Tooltip hpTooltip = new Tooltip();
        hpTooltip.setText(mainCharacter.getHealthPoints() + "/" + mainCharacter.getMaxHealthPoints());
        characterHpFill.setTooltip(hpTooltip);
    }

    private void addBuyListener(Button button, Item itemToBuy, Character characterBuying)
    {
        button.setOnAction(e -> {
            Shop.Buy(characterBuying, itemToBuy);
            updateUI();
        });
    }

    @Override
    public void update(Observable observable, Object o) {
        if(o instanceof FightResult){
//            FightResult r = ((FightResult) o);
//            boolean isFightWon = r.isWon;
//            if(!isFightWon) {
//                showGameFinishScreen();
//            }
//            else{
//                showMainGameScreen();
//                ++killedMonsters;
//                updateUI();
//            }
        }

    }

}
