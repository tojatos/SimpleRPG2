package simplerpg;

public interface IFighter {
    int getAttackPoints();

    void attack(IFighter fighter);

    void receiveDamage(int damage);
}
