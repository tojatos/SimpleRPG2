package simplerpg.AttackMethods;

import simplerpg.IAttack;
import simplerpg.IFighter;

public class Barehanded implements IAttack {
    @Override
    public int getDamage(IFighter attacker) {
        return attacker.getAttackPoints();
    }

    @Override
    public final void attack(IFighter attacker, IFighter defender) {
        defender.receiveDamage(getDamage(attacker));
    }

    @Override
    public String getName() {
        return "Barehanded";
    }

    @Override
    public String getDescription() {
        return "Strikes dealing base fighter damage.";
    }
}
