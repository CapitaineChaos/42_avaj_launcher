package app.aircraft;

import app.coordinates.Coordinates;
import app.tower.WeatherTower;

public class Aircraft extends Flyable implements Runnable {
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

    private void setCoordinates(int d_lat, int d_lon, int d_hgt) {
        this.coordinates.setLatitude(this.coordinates.getLatitude() + d_lat);
        this.coordinates.setLongitude(this.coordinates.getLongitude() + d_lon);
        this.coordinates.setHeight(this.coordinates.getHeight() + d_hgt);
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

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        System.out.println(id + " " + name + " is updating conditions based on weather: " + weather);
    }

    @Override
    public void run() {
        System.out.println(id + " " + name + " is flying at coordinates: " + coordinates);
    }
}
