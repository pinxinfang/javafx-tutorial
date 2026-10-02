import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** Connects the tutorial's chat controls to Duke in Part 3. */
public class Main extends Application {
    private final Duke duke = new Duke();
    private final VBox dialogContainer = new VBox();
    private final TextField userInput = new TextField();
    private final Image userImage = new Image(getClass().getResourceAsStream("/images/DaUser.png"));
    private final Image dukeImage = new Image(getClass().getResourceAsStream("/images/DaDuke.png"));

    /** Creates a chat window and wires Send, Enter, and automatic scrolling. */
    @Override
    public void start(Stage stage) {
        ScrollPane scrollPane = new ScrollPane(dialogContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setPrefSize(400, 557);

        userInput.setPrefSize(324, 42);
        Button sendButton = new Button("Send");
        sendButton.setPrefSize(76, 42);
        sendButton.setOnAction(event -> handleUserInput());
        userInput.setOnAction(event -> handleUserInput());
        dialogContainer.heightProperty().addListener(observable -> scrollPane.setVvalue(1.0));

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
        userInput.requestFocus();
    }

    /** Appends the input and reply, then resets the input for the next message. */
    private void handleUserInput() {
        String input = userInput.getText();
        if (input.isBlank()) {
            userInput.clear();
            return;
        }
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getDukeDialog(duke.getResponse(input), dukeImage));
        userInput.clear();
        userInput.requestFocus();
    }
}
