// TestLogger.java
public class TestLogger {
    public static void main(String[] args) {
        // Access logger from different parts of the application
        Logger logger1 = Logger.getInstance();
        logger1.log("Logging from logger1");
        System.out.println("Logger1 hashcode: " + logger1.hashCode());

        Logger logger2 = Logger.getInstance();
        logger2.log("Logging from logger2");
        System.out.println("Logger2 hashcode: " + logger2.hashCode());

        // Confirming the same instance is used
        if (logger1 == logger2) {
            System.out.println("✅ Same Logger instance is used.");
        } else {
            System.out.println("❌ Different instances exist.");
        }
    }
}
