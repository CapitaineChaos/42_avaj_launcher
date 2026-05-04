package app.tower;

import app.aircraft.Flyable;
import app.aircraft.Aircraft;
import app.tower.exceptions.*;
import app.log.Logger;

import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        observers = new java.util.ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        if (observers.contains(p_flyable))
            throw new TowerHasAlreadyRegisteredException("Aircraft is already registered to the tower.");
        Aircraft aircraft = (Aircraft) p_flyable;
        Logger.getInstance().logLine("[Tower] : " + aircraft.getType() + " " + aircraft.getName() + "(" + aircraft.getId() + ") registered");
        Logger.getInstance().writeLine("Tower says: " + aircraft.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ") registered to weather tower.");
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        if (!observers.contains(p_flyable))
            throw new TowerHasNotRegisteredException("Aircraft is not registered to the tower.");
        Aircraft aircraft = (Aircraft) p_flyable;
        Logger.getInstance().logLine("[Tower] : " + aircraft.getType() + " " + aircraft.getName() + "(" + aircraft.getId() + ") unregistered");
        Logger.getInstance().writeLine("Tower says: " + aircraft.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ") unregistered from weather tower.");
        observers.remove(p_flyable);
    }

    protected void conditionsChanged() {
        List<Flyable> observersCopy = new java.util.ArrayList<>(observers);
        for (Flyable flyable : observersCopy) {
            Logger.getInstance().logLine("[Tower] : Notifying " + ((Aircraft) flyable).getType() + " " + ((Aircraft) flyable).getName() + "(" + ((Aircraft) flyable).getId() + ") -> weather change");
            flyable.updateConditions();
        }
    }

    public List<Flyable> getRegisteredFlyables() {
        return new ArrayList<>(this.observers);
    }
}
