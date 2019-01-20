package simplerpg.AttackMethods;

import simplerpg.IFighter;

public abstract class Sword extends Barehanded {
    private int damage;
    private String name;

    protected Sword(int damage, String name) {
        this.damage = damage;
        this.name = name;
    }

    @Override
    public int getDamage(IFighter attacker) {
        return super.getDamage(attacker) + damage;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\nAdditionally, deals " + damage + " bonus damage.";
    }
}
