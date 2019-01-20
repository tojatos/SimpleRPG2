package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import simplerpg.Character;
import simplerpg.Game;
import simplerpg.Item;
import simplerpg.Shop;

public class BeforeFightController {
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

    private Game getGame() {
        return GameController.Game;
    }

    @FXML
    private void initialize() {
        Character mainCharacter = getGame().mainCharacter;
        updateHpFill(mainCharacter);
        characterNameLabel.setText(mainCharacter.getName());
        attackPointsLabel.setText(Integer.toString(mainCharacter.getAttackPoints()));
        updateGold();
        AddBuyListeners();
    }

    private void AddBuyListeners() {
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
        characterHpFill.setProgress(mainCharacter.getHealthPoints() / mainCharacter.getMaxHealthPoints());
        Tooltip hpTooltip = new Tooltip();
        hpTooltip.setText(mainCharacter.getHealthPoints() + "/" + mainCharacter.getMaxHealthPoints());
        characterHpFill.setTooltip(hpTooltip);
    }

    private void addBuyListener(Button button, Item itemToBuy, Character characterBuying)
    {
        button.setOnAction(e -> {
            Shop.Buy(characterBuying, itemToBuy);
            updateGold();
        });
    }
}
