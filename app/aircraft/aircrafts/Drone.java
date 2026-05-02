package app.aircraft.aircrafts;

import app.aircraft.Aircraft;
import app.coordinates.Coordinates;

public class Drone extends Aircraft {
    public Drone(long id, String p_name, Coordinates p_coordinates) {
        super(id, p_name, p_coordinates);
    }
}