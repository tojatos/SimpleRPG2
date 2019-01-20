package simplerpg;

import simplerpg.AttackMethods.DiamondSword;
import simplerpg.AttackMethods.SilverSword;
import simplerpg.AttackMethods.WoodenSword;
import simplerpg.DefenseMethods.DragonSkin;
import simplerpg.DefenseMethods.LeatherArmour;
import simplerpg.DefenseMethods.SilverArmour;

import java.util.HashMap;
import java.util.Map;

public final class Shop {
    private static Map<Item, Integer> Costs = new HashMap<>();
    static {
        Costs.put(Item.SmallHPPotion,  15);
        Costs.put(Item.MediumHPPotion, 40);
        Costs.put(Item.BigHPPotion,    60);
        Costs.put(Item.WoodenSword,    20);
        Costs.put(Item.SilverSword,    40);
        Costs.put(Item.DiamondSword,   70);
        Costs.put(Item.LeatherArmour,  20);
        Costs.put(Item.SilverArmour,   45);
        Costs.put(Item.DragonSkin,     70);
    }
    public static void Buy(Character character, Item item){
        if(character.getGold() < Costs.get(item)) return;
        else character.setGold(character.getGold() - Costs.get(item));
        GiveItem(character, item);
    }

    private static void GiveItem(Character character, Item item) {
        switch (item){
            case SmallHPPotion:
                character.heal(10);
                break;
            case MediumHPPotion:
                character.heal(30);
                break;
            case BigHPPotion:
                character.heal(60);
                break;
            case WoodenSword:
                character.setAttackMethod(new WoodenSword());
                break;
            case SilverSword:
                character.setAttackMethod(new SilverSword());
                break;
            case DiamondSword:
                character.setAttackMethod(new DiamondSword());
                break;
            case LeatherArmour:
                character.setDefenseMethod(new LeatherArmour());
                break;
            case SilverArmour:
                character.setDefenseMethod(new SilverArmour());
                break;
            case DragonSkin:
                character.setDefenseMethod(new DragonSkin());
                break;
        }
    }
}

