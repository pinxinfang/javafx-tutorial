import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

/** Handles chat events for the controls defined in MainWindow.fxml. */
public class MainWindow {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;
    private final Image userImage = new Image(getClass().getResourceAsStream("/images/DaUser.png"));
    private final Image dukeImage = new Image(getClass().getResourceAsStream("/images/DaDuke.png"));

    /** Runs after FXML has injected the controls, before the window is displayed. */
    @FXML
    private void initialize() {
        // A listener scrolls for new content without preventing the user from scrolling up.
        dialogContainer.heightProperty().addListener(observable -> scrollPane.setVvalue(1.0));
        sendButton.disableProperty().bind(userInput.textProperty().isEmpty());
        Platform.runLater(userInput::requestFocus);
    }

    /** Supplies the chatbot that generates replies for this window. */
    public void setDuke(Duke duke) {
        this.duke = duke;
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(
                "Hello! I'm Duke. Type a message and I'll echo it back.", dukeImage));
    }

    /** Adds the user's message and Duke's reply, then prepares for more input. */
    @FXML
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
