package app.tower.exceptions;

public class TowerHasNotRegisteredException extends RuntimeException {
    public TowerHasNotRegisteredException(String message) {
        super(message);
    }
}
