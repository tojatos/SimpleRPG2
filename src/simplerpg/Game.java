package simplerpg;

import java.util.LinkedList;
import java.util.Observer;
import java.util.Queue;

public class Game {
    public Character mainCharacter;
    public Queue<Monster> monsters;
    public MonsterFight activeFight;

    public Game(Character mainCharacter) {
        this.mainCharacter = mainCharacter;
        instantiateMonsters();

        //initFightersObserver(new Angel());
        initFightersObserver(new FighterObserver());
    }
    private void instantiateMonsters(){
        monsters = new LinkedList<>();
        monsters.add(Monster.createMonster(MonsterClass.Rat));
        monsters.add(Monster.createMonster(MonsterClass.Rat));
        monsters.add(Monster.createMonster(MonsterClass.Rat));
        monsters.add(Monster.createMonster(MonsterClass.Rat));
        monsters.add(Monster.createMonster(MonsterClass.WildDog));
        monsters.add(Monster.createMonster(MonsterClass.Rat));
        monsters.add(Monster.createMonster(MonsterClass.Rat));
        monsters.add(Monster.createMonster(MonsterClass.WildDog));
        monsters.add(Monster.createMonster(MonsterClass.WildDog));
        monsters.add(Monster.createMonster(MonsterClass.WildDog));
        monsters.add(Monster.createMonster(MonsterClass.WildDog));
        monsters.add(Monster.createMonster(MonsterClass.Wolf));
        monsters.add(Monster.createMonster(MonsterClass.WildDog));
        monsters.add(Monster.createMonster(MonsterClass.WildDog));
        monsters.add(Monster.createMonster(MonsterClass.Wolf));
        monsters.add(Monster.createMonster(MonsterClass.Wolf));
        monsters.add(Monster.createMonster(MonsterClass.Wolf));
        monsters.add(Monster.createMonster(MonsterClass.Wolf));
        monsters.add(Monster.createMonster(MonsterClass.Dragon));
    }
    public MonsterFight fight(){
        if(monsters.size() == 0) return null;
        Monster challenger = monsters.remove();
        activeFight = new MonsterFight(mainCharacter, challenger);
        return activeFight;
    }

    private void initFightersObserver(Observer o)
    {
        mainCharacter.addObserver(o);
        monsters.forEach(m -> m.addObserver(o));
    }
}
