package simplerpg;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class FightForm implements Observer {
    public JPanel MainPanel;
    private JButton attackButton;
    private JButton runButton;
    private JLabel currentAttackMethod;
    private JProgressBar hpBar2;
    private JProgressBar hpBar1;
    private JLabel characterName;
    private JLabel monsterName;
    private MonsterFight currentFight;
    public void init(MonsterFight fight){
        FormUtilities.removeAllListeners(attackButton);
        attackButton.addActionListener(a -> fight.attack());
        currentFight = fight;
        updateHpBar1(currentFight.character.getHealthPoints(), currentFight.character.getMaxHealthPoints());
        updateHpBar2(currentFight.monster.getHealthPoints(), currentFight.monster.getMaxHealthPoints());
        characterName.setText(currentFight.character.getName());
        monsterName.setText(currentFight.monster.getName());
        currentFight.character.addObserver(this);
        currentFight.monster.addObserver(this);
    }


    public void updateHpBar1(int current, int max){
        FormUtilities.updateBar(hpBar1, current, max);
        hpBar1.setString("HP (" + current + '/' + max + ")");
    }
    public void updateHpBar2(int current, int max){
        FormUtilities.updateBar(hpBar2, current, max);
        hpBar2.setString("HP (" + current + '/' + max + ")");
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Character) {
            updateHpBar1(currentFight.character.getHealthPoints(), currentFight.character.getMaxHealthPoints());
        } else if (observable instanceof Monster) {
            updateHpBar2(currentFight.monster.getHealthPoints(), currentFight.monster.getMaxHealthPoints());
        }

    }
}
