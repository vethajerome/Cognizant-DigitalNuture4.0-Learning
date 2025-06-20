// Logger.java
public class Logger {

    // Private static instance (lazy initialization)
    private static Logger instance;

    // Private constructor to prevent external instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Public method to get the single instance (Thread-safe lazy initialization)
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Only created once
        }
        return instance;
    }

    // Sample log method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
