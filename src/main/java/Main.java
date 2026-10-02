import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/** Demonstrates the Stage, Scene, and Node hierarchy in tutorial Part 1. */
public class Main extends Application {
    /** Displays a label in the primary application window. */
    @Override
    public void start(Stage stage) {
        Label greeting = new Label("Hello World!");
        stage.setTitle("Duke");
        stage.setScene(new Scene(greeting, 400, 200));
        stage.show();
    }
}
