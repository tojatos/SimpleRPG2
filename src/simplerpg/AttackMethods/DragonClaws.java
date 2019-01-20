package simplerpg.AttackMethods;

import simplerpg.IAttack;
import simplerpg.IFighter;

import java.util.concurrent.ThreadLocalRandom;

public class DragonClaws extends Tackle {

    @Override
    public String getName() {
        return "Dragon Claws";
    }

    @Override
    public int getDamage(IFighter attacker) {
        int damage = super.getDamage(attacker);
        if(isCritical()) {
            damage *= 2;
        }
        return damage;
    }

    private boolean isCritical(){
        return ThreadLocalRandom.current().nextBoolean();
    }
    @Override
    public String getDescription() {
        return super.getDescription() + "\nAdditionally, has 50% chance of doubling damage.";
    }
}
