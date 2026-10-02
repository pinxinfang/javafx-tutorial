import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/** A reusable FXML chat row with a message and its speaker's avatar. */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    /** Uses this object as both the FXML root node and its controller. */
    private DialogBox(String message, Image image) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/DialogBox.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load the chat dialog layout.", e);
        }
        dialog.setText(message);
        displayPicture.setImage(image);
    }

    /** Places the avatar before the text and aligns the reply to the left. */
    private void flip() {
        getChildren().setAll(displayPicture, dialog);
        setAlignment(Pos.TOP_LEFT);
    }

    /** Creates a right-aligned user message. */
    public static DialogBox getUserDialog(String message, Image image) {
        return new DialogBox(message, image);
    }

    /** Creates a left-aligned Duke reply. */
    public static DialogBox getDukeDialog(String message, Image image) {
        DialogBox box = new DialogBox(message, image);
        box.flip();
        return box;
    }
}
