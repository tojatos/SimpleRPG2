package simplerpg;

public interface IAttack extends INameDescription {
    int getDamage(IFighter attacker);
    void attack(IFighter attacker, IFighter defender);
}
