package employees;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class generates an unique file number.
 *
 * @author Matías J. Magni <matias.magni@globallogic.com>
 */
public class FileNumberGenerator {
    // The unique instance of the class.
    private static volatile FileNumberGenerator instance;
    // The mutual exclusion instance.
    private static Object mutex = new Object();
    // File number automatic generator.
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    /**
     * Private default constructor.
     */
    private FileNumberGenerator() {}

    /**
     * Gets the unique instance.
     *
     * @return The unique instance.
     */
    public static FileNumberGenerator getInstance() {
        FileNumberGenerator result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null) {
                    instance = result = new FileNumberGenerator();
                }
            }
        }
        return result;
    }

    /**
     * Gets a new ID automatically generated.
     *
     * @return The generated ID number.
     */
    public synchronized int getId() {
        return ID_GENERATOR.getAndIncrement();
    }
}