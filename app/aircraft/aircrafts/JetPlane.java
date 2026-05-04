package app.aircraft.aircrafts;

import app.aircraft.Aircraft;
import app.coordinates.Coordinates;
import app.aircraft.Messages;

import java.util.Map;

public class JetPlane extends Aircraft {
    public JetPlane(long id, String p_name, Coordinates p_coordinates) {
        super(id, p_name, p_coordinates);

        this.type = "JetPlane";

        this.weatherDeltas = Map.of(
            "SUN", Coordinates.createCoordinates(0, 10, 2),
            "RAIN", Coordinates.createCoordinates(0, 5, 0),
            "FOG", Coordinates.createCoordinates(0, 1, 0),
            "SNOW", Coordinates.createCoordinates(0, 0, -7)
        );
        
        this.messages = Map.of(
            "SUN", "It's sunny. Let's enjoy the good weather.",
            "RAIN", "It's raining. Better watch out for lightings.",
            "FOG", "WTF! Fog is too thick.",
            "SNOW", "It's snowing. It's dangerous to fly in this weather."
        );
    }
}