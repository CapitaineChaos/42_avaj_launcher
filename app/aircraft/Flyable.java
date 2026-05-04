package app.aircraft;

import app.tower.WeatherTower;
import app.coordinates.Coordinates;

import java.util.Map;

public abstract class Flyable {
    protected WeatherTower weatherTower;
    protected Map<String, Coordinates> weatherDeltas;
    protected Map<String, String> messages;
    
    public abstract void updateConditions();
    public abstract void registerTower(WeatherTower p_tower);
    public abstract void unregisterTower();
}
