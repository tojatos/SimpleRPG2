package simplerpg;

import javax.swing.*;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

public class MainForm implements Observer {

    private volatile static MainForm instance;


    public static MainForm getInstance() {
        if (instance == null) {
            synchronized (MainForm.class) {
                if (instance == null) {
                    instance = new MainForm();
                }
            }
        }

        return instance;
    }
    public static JFrame mainFrame;
    private JPanel MainPanel;
    private JTextField characterNameField;
    private JButton letSGoButton;
    private ButtonGroup characterClassGroup;

    private simplerpg.GameForm GameForm;
    private FightForm FightForm;
    private GameOverForm GameOverForm;
    private int killedMonsters = 0;

    private Game game;
    public static void main(String[] args) {
        initializeForm();
    }
    private static void initializeForm(){
        JFrame frame = new JFrame("Simple RPG");
        mainFrame = frame;
        frame.setContentPane(MainForm.getInstance().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); //center frame
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private MainForm(){
        letSGoButton.addActionListener(a-> startGame());
    }

    private void startGame(){
        if(characterNameField.getText().equals("")) return;
        AbstractButton selectedClassButton = getSelectedClassButton();
        if(selectedClassButton == null) return;
        CharacterClass selectedClass = CharacterClass.valueOf(selectedClassButton.getText());
        Character mainCharacter = Character.createCharacter(selectedClass, characterNameField.getText());

        game = new Game(mainCharacter);
        initializeGameForm(game);
        initializeFightForm();
        initializeGameOverForm();

        mainFrame.setSize(1000, 600);
        showMainGameScreen();
        initObserver();
    }

    private AbstractButton getSelectedClassButton() {
        try {
            return Collections
                    .list(characterClassGroup.getElements())
                    .stream().filter(b -> b.isSelected())
                    .findFirst().get();
        } catch(Exception e) {
            return null;
        }
    }

    private void initializeGameForm(Game game){
        GameForm = new GameForm();
        Character m = game.mainCharacter;
        updateUI();
        GameForm.fightButton.addActionListener(a -> startFight());
        addBuyListener(GameForm.buySmallHealthPotion,   Item.SmallHPPotion,   m);
        addBuyListener(GameForm.buyMediumHealthPotion,  Item.MediumHPPotion,  m);
        addBuyListener(GameForm.buyBigHealthPotion,     Item.BigHPPotion,     m);
        addBuyListener(GameForm.buyWoodenSword,         Item.WoodenSword,     m);
        addBuyListener(GameForm.buySilverSword,         Item.SilverSword,     m);
        addBuyListener(GameForm.buyDiamondSword,        Item.DiamondSword,    m);
        addBuyListener(GameForm.buyLeatherArmour,       Item.LeatherArmour,   m);
        addBuyListener(GameForm.buySilverArmour,        Item.SilverArmour,    m);
        addBuyListener(GameForm.buyDragonSkin,          Item.DragonSkin,      m);
    }
    private void addBuyListener(JButton button, Item itemToBuy, Character characterBuying)
    {
        button.addActionListener(a -> {
            Shop.Buy(characterBuying, itemToBuy);
            MainForm.getInstance().updateUI();
        });
    }

    private void initializeFightForm(){
        FightForm = new FightForm();
    }

    private void initializeGameOverForm(){
        GameOverForm = new GameOverForm();
    }
    public static void changePanel(JPanel newPanel){
        mainFrame.setContentPane(newPanel);
        mainFrame.validate();
        mainFrame.repaint();
        mainFrame.setLocationRelativeTo(null);
    }


    @Override
    public void update(Observable observable, Object o) {
        if(o instanceof FightResult){
            FightResult r = ((FightResult) o);
            boolean isFightWon = r.isWon;
            if(!isFightWon) {
                showGameFinishScreen();
            }
            else{
//                r.acquiredExperience, r.acquiredGold
                showMainGameScreen();
                ++killedMonsters;
                updateUI();
            }
        }
    }
    public void updateUI(){
        Character m = game.mainCharacter;
        GameForm.updateCurrentAttackMethodLabel(m.getAttackMethod());
        GameForm.updateCurrentDefenseMethodLabel(m.getDefenseMethod());
        GameForm.updateHpBar(m.getHealthPoints(), m.getMaxHealthPoints());
//        GameForm.updateXpBar(m.getExperience(), 300);
        GameForm.updateCharacterName(m.getName());
        GameForm.updateGold(m.getGold());
        GameForm.updateAttackPoints(m.getAttackPoints());
        if(game.monsters.size() != 0){
            GameForm.nextMonster.setText("Next monster: " + game.monsters.peek().getName());
        }
        else{
            GameForm.nextMonster.setText("Next monster: ???");
        }
    }

    public void startFight(){
        MonsterFight fight = game.fight();
        if(fight == null) showGameWonScreen();
        fight.addObserver(this);
        showFightScreen();
        FightForm.init(fight);
    }

    private void showGameWonScreen() {
        changePanel(new GameWonForm().MainPanel);
    }

    private void showMainGameScreen() {
        changePanel(GameForm.MainPanel);
    }
    private void showFightScreen() {
        changePanel(FightForm.MainPanel);
    }

    private void showGameFinishScreen() {
        changePanel(GameOverForm.MainPanel);
        GameOverForm.monstersKilled.setText("Monsters killed: " + killedMonsters);
    }

    private void initObserver(){
        game.mainCharacter.addObserver(this);
        game.monsters.forEach(m -> m.addObserver(this));
    }
}
