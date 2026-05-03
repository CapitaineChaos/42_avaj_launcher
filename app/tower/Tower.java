package app.tower;

import java.util.List;
import app.aircraft.Flyable;
import app.aircraft.Aircraft;
import app.tower.exceptions.*;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        observers = new java.util.ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        if (observers.contains(p_flyable))
            throw new TowerHasAlreadyRegisteredException("Aircraft is already registered to the tower.");
        Aircraft aircraft = (Aircraft) p_flyable;
        System.out.println("Tower says: " + aircraft.getType() + " " + aircraft.getName() + "(" + aircraft.getId() + ") registered to weather tower.");
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        if (!observers.contains(p_flyable))
            throw new TowerHasNotRegisteredException("Aircraft is not registered to the tower.");
        Aircraft aircraft = (Aircraft) p_flyable;
        System.out.println("Tower says: " + aircraft.getType() + " " + aircraft.getName() + "(" + aircraft.getId() + ") unregistered from weather tower.");
        observers.remove(p_flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            if (!observers.contains(flyable))
                throw new TowerHasNotRegisteredException("Aircraft is not registered to the tower.");
            flyable.updateConditions();
        }
    }
}
