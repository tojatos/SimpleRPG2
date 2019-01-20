package simplerpg;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Angel implements Observer {
    private ArrayList Fighters = new ArrayList();

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof Fighter){
            Fighter f = (Fighter) observable;
            if(!f.isAlive() && !Fighters.contains(f)){
                Fighters.add(f);
                f.heal(-f.getHealthPoints() + 1);
                if(f instanceof Monster){
                    if(f.getName() == "Rat"){
                        f.heal(3);
                    }

                }
            }
        }
    }
}

