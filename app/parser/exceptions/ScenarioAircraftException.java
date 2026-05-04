package app.parser.exceptions;

public class ScenarioAircraftException extends RuntimeException {
    private static final String RED_BOLD = "\u001B[1;31m";
    private static final String RESET = "\u001B[0m";

    public ScenarioAircraftException(String message) {
        super(RED_BOLD + "@@@[ Aircraft Data Exception ]@@@: " + RESET + message);    
    }
}