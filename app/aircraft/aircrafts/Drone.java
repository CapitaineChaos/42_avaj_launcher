package app.aircraft.aircrafts;

import app.aircraft.Aircraft;
import app.aircraft.Messages;
import app.coordinates.Coordinates;

import java.util.Map;

public class Drone extends Aircraft {
    public Drone(long id, String p_name, Coordinates p_coordinates) {
        super(id, p_name, p_coordinates);

        this.type = "Drone";

        this.weatherDeltas = Map.of(
            "SUN", Coordinates.createCoordinates(5, 1, 5),
            "RAIN", Coordinates.createCoordinates(0, 0, -10),
            "FOG", Coordinates.createCoordinates(3, 2, 0),
            "SNOW", Coordinates.createCoordinates(0, 1, -20)
        );
        
        this.messages = Map.of(
            "SUN", "I'm flying high in the sun!",
            "RAIN", "Rain is not good for me.",
            "FOG", "Fog is making it hard to navigate.",
            "SNOW", "Snow is too heavy. I can't fly."
        );
    }
}