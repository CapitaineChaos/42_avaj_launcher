package app.log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class Logger {
    private static Logger instance;
    
    private final BufferedWriter writer;
    private final BufferedWriter debug;

    private BufferedWriter getNewWriter(Path path) {
        try {
            return Files.newBufferedWriter(
                path, 
                StandardOpenOption.CREATE, 
                StandardOpenOption.TRUNCATE_EXISTING, 
                StandardOpenOption.WRITE
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to create new writer: " + e.getMessage(), e);
        }
    }

    private Logger(Path log_path, Path debug_path) {
        this.writer = getNewWriter(log_path);
        this.debug = getNewWriter(debug_path);
    }


    public static Logger init(Path log_path, Path debug_path) {
        if (instance != null) {
            throw new IllegalStateException("Logger has already been initialized.");
        }
        instance = new Logger(log_path, debug_path);
        return instance;
    }

    public static Logger getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Logger has not been initialized. Call Logger.init(Path, Path) first.");
        }
        return instance;
    }

    public void logLine(String message) {
        try {
            debug.write(message);
            debug.newLine();
            debug.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write debug message: " + e.getMessage(), e);
        }
    }

    public void writeLine(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Failed to write log message: " + e.getMessage(), e);
        }
    }

    public void close() {
        try {
            writer.close();
            debug.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to close logger: " + e.getMessage(), e);
        }
    }
}