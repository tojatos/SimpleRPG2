package simplerpg;

import javax.swing.*;

public class GameForm {
    public JPanel MainPanel;
    public JButton fightButton;
    private JPanel CharacterEQ;
    private JLabel currentAttackMethod;
    private JLabel currentDefenseMethod;
    private JProgressBar hpBar;
    private JProgressBar xpBar;
    private JLabel characterName;
    private JLabel gold;
    private JLabel attackPoints;
    public JButton buyLeatherArmour;
    public JButton buyWoodenSword;
    public JButton buySmallHealthPotion;
    public JButton buyMediumHealthPotion;
    public JButton buyBigHealthPotion;
    public JButton buySilverSword;
    public JButton buyDiamondSword;
    public JButton buySilverArmour;
    public JButton buyDragonSkin;
    public JLabel nextMonster;

    public void updateCurrentAttackMethodLabel(IAttack method){
        updateMethodLabel(currentAttackMethod, method);
    }
    public void updateCurrentDefenseMethodLabel(IDefense method){
        updateMethodLabel(currentDefenseMethod, method);
    }
    private void updateMethodLabel(JLabel label, INameDescription method){
        String text = method.getName() + "\n\n" + method.getDescription();
        text = "<html>" + text;
        text = text.replaceAll("\n", "<br>");
        label.setText(text);
    }
    private static void updateBar(JProgressBar bar, int current, int max){
        bar.setMaximum(max);
        bar.setValue(current);
    }
    public void updateHpBar(int current, int max){
        updateBar(hpBar, current, max);
        hpBar.setString("HP (" + current + '/' + max + ")");
    }
    public void updateXpBar(int current, int max){
        updateBar(xpBar, current, max);
        xpBar.setString("XP (" + current + '/' + max + ")");
    }
    public void updateCharacterName(String newName){
        characterName.setText(newName);
    }
    public void updateGold(int newValue){
        gold.setText("Gold: " + newValue);
    }
    public void updateAttackPoints(int newValue){
        attackPoints.setText("Attack points: " + newValue);
    }

}
