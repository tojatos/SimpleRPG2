package simplerpg.DefenseMethods;

import simplerpg.IDefense;
import simplerpg.IFighter;

public class NoDefense implements IDefense {
    @Override
    public int getDefense(IFighter defender, int incomingDamage) {
        return 0;
    }

    @Override
    public String getName() {
        return "No defense";
    }

    @Override
    public String getDescription() {
        return "Actually, they doesn't know how to defend themselves.";
    }
}
