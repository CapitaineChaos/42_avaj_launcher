package app.tower;

import java.util.List;
import app.aircraft.Flyable;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        observers = new java.util.ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}
