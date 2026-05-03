package app.aircraft.aircrafts;

import app.aircraft.Aircraft;
import app.coordinates.Coordinates;

public class Helicopter extends Aircraft {
    public Helicopter(long id, String p_name, Coordinates p_coordinates) {
        super(id, p_name, p_coordinates);
        this.type = "Helicopter";
    }
}