package app.aircraft;

public class AircraftFactory {
    private static AircraftFactory instance;

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    private AircraftFactory() {
    }

    public static String newAircraft(String type, String name, String coordinates) {
        if (type.equalsIgnoreCase("Helicopter")) {
            return "Helicopter " + name + " created with coordinates: " + coordinates;
        } else if (type.equalsIgnoreCase("JetPlane")) {
            return "JetPlane " + name + " created with coordinates: " + coordinates;
        } else if (type.equalsIgnoreCase("Baloon")) {
            return "Baloon " + name + " created with coordinates: " + coordinates;
        }
        return null;
    }
}
