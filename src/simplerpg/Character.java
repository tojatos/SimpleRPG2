package simplerpg;

import simplerpg.AttackMethods.Barehanded;
import simplerpg.AttackMethods.WoodenSword;
import simplerpg.DefenseMethods.LeatherArmour;
import simplerpg.DefenseMethods.NoDefense;

public class Character extends Fighter {
    public int killedMonsters;
    //    private int experience = 0;
    private int gold = 0;

    private Character(int healthPoints, int attackPoints, String name, IAttack attackMethod, IDefense defenseMethod) {
        super(healthPoints, attackPoints, name, attackMethod, defenseMethod);
    }

    public static Character createCharacter(CharacterClass aClass, String name) {
        switch (aClass) {
            case Berserk:
                return new Character(50, 35, name, new Barehanded(), new NoDefense());
            case Warrior:
                return new Character(150, 10, name, new WoodenSword(), new LeatherArmour());
            case Paladin:
                return new Character(100, 20, name, new WoodenSword(), new NoDefense());
        }
        return null;
    }


    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
