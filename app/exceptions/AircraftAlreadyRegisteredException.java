package app.exceptions;

public class AircraftAlreadyRegisteredException extends RuntimeException {
    public AircraftAlreadyRegisteredException(String message) {
        super(message);
    }
}