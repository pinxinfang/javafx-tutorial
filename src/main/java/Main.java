import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** Builds the tutorial's chat layout using JavaFX controls in Part 2. */
public class Main extends Application {
    /** Creates a fixed-size chat window with a sample dialog. */
    @Override
    public void start(Stage stage) {
        VBox dialogContainer = new VBox();
        ScrollPane scrollPane = new ScrollPane(dialogContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefSize(400, 557);

        TextField userInput = new TextField();
        userInput.setPrefSize(324, 42);
        Button sendButton = new Button("Send");
        sendButton.setPrefSize(76, 42);
        Image userImage = new Image(getClass().getResourceAsStream("/images/DaUser.png"));
        dialogContainer.getChildren().add(new DialogBox("Hello!", userImage));

        AnchorPane root = new AnchorPane(scrollPane, userInput, sendButton);
        root.setPrefSize(400, 600);
        AnchorPane.setTopAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(userInput, 1.0);
        AnchorPane.setLeftAnchor(userInput, 0.0);
        AnchorPane.setBottomAnchor(sendButton, 1.0);
        AnchorPane.setRightAnchor(sendButton, 0.0);

        stage.setTitle("Duke");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
