package app.parser.exceptions;

public class ScenarioDataException extends RuntimeException {
    private static final String RED_BOLD = "\u001B[1;31m";
    private static final String RESET = "\u001B[0m";

    public ScenarioDataException(String message) {
        super(RED_BOLD + "@@@[ Data Exception ]@@@: " + RESET + message);    
    }
}
