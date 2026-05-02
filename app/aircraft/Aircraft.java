package app.aircraft;

import app.coordinates.Coordinates;

public class Aircraft extends Flyable implements Runnable {
    protected String name;
    protected long id;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.name = p_name;
        this.id = p_id;
        this.coordinates = p_coordinates;
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
    public void updateConditions() {
        System.out.println(id + " " + name + " is updating conditions based on weather.");
    }

    @Override
    public void run() {
        System.out.println(id + " " + name + " is flying at coordinates: " + coordinates);
    }
}
