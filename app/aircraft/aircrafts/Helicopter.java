package app.aircraft.aircrafts;

import app.aircraft.Aircraft;
import app.aircraft.Messages;
import app.coordinates.Coordinates;

import java.util.Map;

public class Helicopter extends Aircraft {
    public Helicopter(long id, String p_name, Coordinates p_coordinates) {
        super(id, p_name, p_coordinates);

        this.type = "Helicopter";

        this.weatherDeltas = Map.of(
            "SUN", Coordinates.createCoordinates(10, 0, 2),
            "RAIN", Coordinates.createCoordinates(5, 0, 0),
            "FOG", Coordinates.createCoordinates(1, 0, 0),
            "SNOW", Coordinates.createCoordinates(0, 0, -12)
        );
        
        this.messages = Map.of(
            "SUN", "This is hot.",
            "RAIN", "Oh oh, it's raining. Rust is not good for my rotor.",
            "FOG", "I can't see anything! This fog is not helping.",
            "SNOW", "It's snowing. I hope I survive."
        );
    }
}