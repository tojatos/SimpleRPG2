package simplerpg.DefenseMethods;

import simplerpg.IDefense;
import simplerpg.IFighter;

public abstract class Armour implements IDefense {
    private int defensePoints;
    private String name;

    protected Armour(int defensePoints, String name) {
        this.defensePoints = defensePoints;
        this.name = name;
    }

    @Override
    public int getDefense(IFighter defender, int incomingDamage) {
        return defensePoints;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return "Blocks " + defensePoints + " incoming damage.";
    }
}
