package app.parser.exceptions;

public class ScenarioFileException extends RuntimeException {
    private static final String RED_BOLD = "\u001B[1;31m";
    private static final String RESET = "\u001B[0m";

    public ScenarioFileException(String message) {
        super(RED_BOLD + "@@@[ File Exception ]@@@: " + RESET + message);
    }
}