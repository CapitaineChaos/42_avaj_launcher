package app.log;

public class LoggerException extends RuntimeException {
    private static final String RED_BOLD = "\u001B[1;31m";
    private static final String RESET = "\u001B[0m";

    public LoggerException(String message) {
        super(RED_BOLD + "@@@[ Logger Exception ]@@@: " + RESET + message);    
    }

    public LoggerException(String message, Throwable cause) {
        super(RED_BOLD + "@@@[ Logger Exception ]@@@: " + RESET + message, cause);    
    }
}