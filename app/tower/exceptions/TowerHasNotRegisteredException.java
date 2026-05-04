package app.tower.exceptions;

public class TowerHasNotRegisteredException extends RuntimeException {
    private static final String RED_BOLD = "\u001B[1;31m";
    private static final String RESET = "\u001B[0m";

    public TowerHasNotRegisteredException(String message) {
        super(RED_BOLD + "@@@[ Tower Exception ]@@@: " + RESET + message);
    }
}
