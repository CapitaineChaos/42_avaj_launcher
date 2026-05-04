package app.aircraft;

public class AircraftUnknownException extends Exception {
    private static final String RED_BOLD = "\u001B[1;31m";
    private static final String RESET = "\u001B[0m";

    public AircraftUnknownException(String message) {
        super(RED_BOLD + "@@@[ Aircraft Exception ]@@@: " + RESET + message);
    }
}
