package app.log;

public class LoggerUsageException extends RuntimeException {
    private static final String RED_BOLD = "\u001B[1;31m";
    private static final String RESET = "\u001B[0m";

    public LoggerUsageException(String message) {
        super(RED_BOLD + "@@@[ Logger Usage Exception ]@@@: " + RESET + message);    
    }

}