package app.tower;

import java.util.List;
import app.aircraft.Flyable;
import app.exceptions.AircraftAlreadyRegisteredException;
import app.exceptions.AircraftNotRegisteredException;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        observers = new java.util.ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        if (observers.contains(p_flyable))
            throw new AircraftAlreadyRegisteredException("Aircraft is already registered to the tower.");
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        if (!observers.contains(p_flyable))
            throw new AircraftNotRegisteredException("Aircraft is not registered to the tower.");
        observers.remove(p_flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            if (!observers.contains(flyable))
                throw new AircraftNotRegisteredException("Aircraft is not registered to the tower.");
            flyable.updateConditions();
        }
    }
}
