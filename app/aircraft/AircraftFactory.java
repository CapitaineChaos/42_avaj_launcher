package app.aircraft;

import app.coordinates.Coordinates;
import app.aircraft.aircrafts.*;

import java.lang.reflect.Constructor;


public class AircraftFactory {
    private static AircraftFactory instance;
    private static final String AIRCRAFT_PACKAGE = "app.aircraft.aircrafts.";
    private long idCounter = 0;

    public static AircraftFactory getInstance() {
        if (instance == null)
            instance = new AircraftFactory();
        return instance;
    }

    private AircraftFactory() {}

    public Aircraft newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AircraftUnknownException, ReflectiveOperationException {
        Class<?> rawClass;

        try {
            rawClass = Class.forName(AIRCRAFT_PACKAGE + p_type);
        } catch (ClassNotFoundException e) {
            throw new AircraftUnknownException("Unknown aircraft type: " + p_type);
        }

        if (!Aircraft.class.isAssignableFrom(rawClass)) {
            throw new AircraftUnknownException("Unknown aircraft type: " + p_type);
        }

        Class<? extends Aircraft> aircraftClass = rawClass.asSubclass(Aircraft.class);
        Constructor<? extends Aircraft> ctor = aircraftClass.getConstructor(long.class, String.class, Coordinates.class);
        return ctor.newInstance(++idCounter, p_name, p_coordinates);
    }
}
