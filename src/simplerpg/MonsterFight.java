package simplerpg;

import java.util.Observable;

public class MonsterFight extends Observable {
    public Character character;
    public Monster monster;

    public MonsterFight(Character character, Monster monster) {
        this.character = character;
        this.monster = monster;
    }

    private void makeAction(Runnable action) {
        action.run();
        if ( ! monster.isAlive()){
            fightWon();
            return;
        }
        monster.attack(character);
        if( ! character.isAlive()) {
            fightLost();
            return;
        }
    }
    public void attack(){
        makeAction(()-> character.attack(monster));
    }

    private void fightWon() {
//        character.setExperience(character.getExperience() + monster.experienceWorth);
        character.setGold(character.getGold() + monster.goldWorth);
        FightResult result = new FightResult();
        result.isWon = true;
//        result.acquiredExperience = monster.experienceWorth;
        result.acquiredGold = monster.goldWorth;

        notifyFightResult(result);
    }

    private void fightLost() {
        FightResult result = new FightResult();
        result.isWon = false;
        notifyFightResult(result);
    }
    private void notifyFightResult(FightResult result){
        setChanged();
        notifyObservers(result);
    }
}
