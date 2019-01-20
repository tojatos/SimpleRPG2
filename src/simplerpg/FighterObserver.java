package simplerpg;

import java.util.Observable;
import java.util.Observer;

public class FighterObserver implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Fighter){
            Fighter f = (Fighter) observable;
            System.out.println("==================================");
            System.out.println(f.getName() + " has changed state!");
            System.out.println("HP: " + f.getHealthPoints());
            System.out.println("Name of attack method: " + f.getAttackMethod().getName());
            System.out.println("Description of attack method: " + f.getAttackMethod().getDescription());
            System.out.println("==================================");
        }
    }
}
