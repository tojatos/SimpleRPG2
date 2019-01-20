package simplerpg;

import simplerpg.AttackMethods.Barehanded;
import simplerpg.AttackMethods.DragonClaws;
import simplerpg.AttackMethods.Tackle;
import simplerpg.DefenseMethods.DragonSkin;
import simplerpg.DefenseMethods.NoDefense;
import simplerpg.DefenseMethods.ThickSkin;

import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Fighter {
//    public final int experienceWorth;
    public final int goldWorth;

    private Monster(int healthPoints,
                    int attackPoints,
                    String name,
                    IAttack attackMethod,
                    IDefense defenseMethod,
                    int minGoldWorth,
                    int experienceWorth) {
        super(healthPoints, attackPoints, name, attackMethod, defenseMethod);
        this.goldWorth = ThreadLocalRandom.current().nextInt(minGoldWorth, minGoldWorth + 10);
//        this.experienceWorth = experienceWorth;
    }

    public static Monster createMonster(MonsterClass aClass) {
        switch (aClass) {
            case Rat:
                return new Monster(30, 6,  "Rat", new Barehanded(), new NoDefense(), 3, 5);
            case WildDog:
                return new Monster(50, 8,  "Wild Dog", new Tackle(), new NoDefense(), 6, 10);
            case Wolf:
                return new Monster(60, 10,  "Wolf", new Tackle(), new ThickSkin(), 9, 15);
            case Dragon:
                return new Monster(100, 20,  "Dragon", new DragonClaws(), new DragonSkin(), 150, 500);
        }

        return null;
    }
}
