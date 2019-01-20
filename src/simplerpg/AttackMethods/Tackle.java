package simplerpg.AttackMethods;

import simplerpg.IFighter;

import java.util.concurrent.ThreadLocalRandom;

public class Tackle extends Barehanded {

    private static final int MIN_ADDITIONAL_DAMAGE = 0;
    private static final int MAX_ADDITIONAL_DAMAGE = 6;
    @Override
    public int getDamage(IFighter attacker) {
        return super.getDamage(attacker) + getAdditionalDamage();
    }

    @Override
    public String getName() {
        return "Tackle";
    }

    private int getAdditionalDamage(){
        return ThreadLocalRandom.current().nextInt(MIN_ADDITIONAL_DAMAGE, MAX_ADDITIONAL_DAMAGE + 1);
    }

    @Override
    public String getDescription() {
        return String.format("%s\nAdditionally, deals bonus %d-%d damage.", super.getDescription(), MIN_ADDITIONAL_DAMAGE, MAX_ADDITIONAL_DAMAGE);
    }
}
