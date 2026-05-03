package app.aircraft.aircrafts;

import app.aircraft.Aircraft;
import app.coordinates.Coordinates;

public class Baloon extends Aircraft {

    public Baloon(long id, String p_name, Coordinates p_coordinates) {
        super(id, p_name, p_coordinates);
        this.type = "Baloon";
    }

    private void sun() {
        this.longitude += 2;
        this.height += 4;
    }

    private void rain() {
        this.height -= 5;
    }

    private void fog() {
        this.height -= 3;
    }

    private void snow() {
        this.height -= 15;
    }
}