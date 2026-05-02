package app.exceptions;

public class AircraftNotRegisteredException extends RuntimeException {
    public AircraftNotRegisteredException(String message) {
        super(message);
    }
}
