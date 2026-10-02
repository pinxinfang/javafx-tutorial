import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/** Loads the FXML view and connects its controller to Duke. */
public class Main extends Application {
    /** Starts the chat window, reporting missing or invalid FXML as a startup failure. */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
        AnchorPane root = loader.load();
        loader.<MainWindow>getController().setDuke(new Duke());
        stage.setTitle("Duke — JavaFX Tutorial");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
