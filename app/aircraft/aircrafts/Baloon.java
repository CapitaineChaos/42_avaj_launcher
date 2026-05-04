package app.aircraft.aircrafts;

import app.aircraft.Aircraft;
import app.aircraft.Messages;
import app.coordinates.Coordinates;

import java.util.Map;

public class Baloon extends Aircraft {
    public Baloon(long id, String p_name, Coordinates p_coordinates) {
        super(id, p_name, p_coordinates);

        this.type = "Baloon";

        this.weatherDeltas = Map.of(
            "SUN", Coordinates.createCoordinates(2, 0, 4),
            "RAIN", Coordinates.createCoordinates(0, 0, -5),
            "FOG", Coordinates.createCoordinates(0, 0, -3),
            "SNOW", Coordinates.createCoordinates(0, 0, -15)
        );

        this.messages = Map.of(
            "SUN", "Let's enjoy the good weather and take some pics.",
            "RAIN", "Damn you rain! You messed up my baloon.",
            "FOG", "I can't see anything! Fog is too thick.",
            "SNOW", "It's snowing. I hope I survive."
        );
    }
}
