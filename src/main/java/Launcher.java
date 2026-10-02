import javafx.application.Application;

/** Starts JavaFX through a class that does not extend Application. */
public class Launcher {
    /** Passes command-line arguments to the JavaFX application. */
    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }
}
