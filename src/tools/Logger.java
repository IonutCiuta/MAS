package tools;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public interface Logger {

    default void log(String message) {
        System.out.println(String.format("[%s]: %s", getClass().getSimpleName(), message));
    }
}
