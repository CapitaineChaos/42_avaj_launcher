package app.parser.exceptions;

public class ScenarioDataFormatException extends RuntimeException {
    private static final String RED_BOLD = "\u001B[1;31m";
    private static final String RESET = "\u001B[0m";

    public ScenarioDataFormatException(String message) {
        super(RED_BOLD + "@@@[ Data Format Exception ]@@@: " + RESET + message);    
    }
}
