package app.tower.exceptions;

public class TowerHasAlreadyRegisteredException extends RuntimeException {
    public TowerHasAlreadyRegisteredException(String message) {
        super(message);
    }
}
