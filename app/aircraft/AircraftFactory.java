package app.aircraft;

import app.coordinates.Coordinates;

public class AircraftFactory {
    private static AircraftFactory instance;

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    private AircraftFactory() {}

    public static String newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        if (p_type.equalsIgnoreCase("Helicopter")) {
            return "Helicopter " + p_name + " created with coordinates: " + p_coordinates;
        } else if (p_type.equalsIgnoreCase("JetPlane")) {
            return "JetPlane " + p_name + " created with coordinates: " + p_coordinates;
        } else if (p_type.equalsIgnoreCase("Baloon")) {
            return "Baloon " + p_name + " created with coordinates: " + p_coordinates;
        }
        return null;
    }
}
