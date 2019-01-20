package simplerpg;

import java.util.Observable;

public abstract class Fighter extends Observable implements IFighter {
    private int MaxHealthPoints;
    private int HealthPoints;
    private int AttackPoints;
    private final String Name;

    private IAttack attackMethod;
    private IDefense defenseMethod;

    protected Fighter(int healthPoints, int attackPoints, String name, IAttack attackMethod, IDefense defenseMethod) {
        setMaxHealthPoints(healthPoints);
        setHealthPoints(healthPoints);
        setAttackPoints(attackPoints);
        Name = name;
        this.setAttackMethod(attackMethod);
        this.setDefenseMethod(defenseMethod);
    }

    public final boolean isAlive() {
        return getHealthPoints() > 0;
    }

    @Override
    public void attack(IFighter fighter) {
        getAttackMethod().attack(this, fighter);
    }

    @Override
    public void receiveDamage(int damage) {
        int damageBlocked = getDefenseMethod().getDefense(this, damage);
        int damageReceived = Math.max(damage - damageBlocked, 0);
        setHealthPoints(getHealthPoints() - damageReceived);
    }

    private void notifyHPChange(){
        setChanged();
        notifyObservers();
    }

    public void heal(int amount){
        setHealthPoints(getHealthPoints() + amount);
        if(getHealthPoints() > getMaxHealthPoints()) setHealthPoints(getMaxHealthPoints());
    }

    public int getMaxHealthPoints() {
        return MaxHealthPoints;
    }

    private void setMaxHealthPoints(int maxHealthPoints) {
        MaxHealthPoints = maxHealthPoints;
    }

    public int getHealthPoints() {
        return HealthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        HealthPoints = healthPoints;
        notifyHPChange();
    }

    @Override
    public final int getAttackPoints() {
        return AttackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        AttackPoints = attackPoints;
    }

    public String getName() {
        return Name;
    }

    public IAttack getAttackMethod() {
        return attackMethod;
    }

    public void setAttackMethod(IAttack attackMethod) {
        this.attackMethod = attackMethod;
    }

    public IDefense getDefenseMethod() {
        return defenseMethod;
    }

    public void setDefenseMethod(IDefense defenseMethod) {
        this.defenseMethod = defenseMethod;
    }
}
