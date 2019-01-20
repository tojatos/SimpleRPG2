package simplerpg;

public interface IDefense extends INameDescription {
    int getDefense(IFighter defender, int incomingDamage);
}
