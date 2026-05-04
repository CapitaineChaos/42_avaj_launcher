package app.aircraft;

import app.coordinates.Coordinates;
import app.aircraft.Messages;
import app.tower.WeatherTower;
import app.log.Logger;

public class Aircraft extends Flyable {
    protected String type;
    protected String name;
    protected long id;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.name = p_name;
        this.id = p_id;
        this.coordinates = p_coordinates;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }

    @Override
    public void unregisterTower() {
        this.weatherTower.unregister(this);
        this.weatherTower = null;
    }

    private void updateCoordinates(Coordinates change) {
        this.coordinates.setLatitude(this.coordinates.getLatitude() + change.getLatitude());
        this.coordinates.setLongitude(this.coordinates.getLongitude() + change.getLongitude());
        int newHeight = this.coordinates.getHeight() + change.getHeight();
        if (newHeight > 100) {
            this.coordinates.setHeight(100);
            Logger.getInstance().logLine("[" + this.type + "#" + this.name + "(" + this.id + ")]: Height capped at 100");
        } else if (newHeight <= 0) {
            this.coordinates.setHeight(0);
            Logger.getInstance().logLine("[" + this.type + "#" + this.name + "(" + this.id + ")]: Landing at " + coordinates);
            Logger.getInstance().writeLine(this.type + "#" + this.name + "(" + this.id + ") landing at: " + coordinates);
            unregisterTower();
        } else {
            this.coordinates.setHeight(newHeight);
        }
        Logger.getInstance().logLine("[" + this.type + "#" + this.name + "(" + this.id + ")]: Current coordinates    " + coordinates);
        Logger.getInstance().logLine("[" + this.type + "#" + this.name + "(" + this.id + ")]: Coordinates changed by " + change);
        Logger.getInstance().logLine("[" + this.type + "#" + this.name + "(" + this.id + ")]: Updated coordinates to " + coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        Logger.getInstance().logLine("[" + this.type + "#" + this.name + "(" + this.id + ")]: Current weather is " + weather);
        Logger.getInstance().writeLine(this.type + "#" + this.name + "(" + this.id + "): " + messages.get(weather));
        updateCoordinates(weatherDeltas.get(weather));
    }
}
