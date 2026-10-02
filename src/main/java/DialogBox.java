import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

/** A reusable chat row containing a message and the speaker's avatar. */
public class DialogBox extends HBox {
    /** Builds a right-aligned row for the supplied message and avatar. */
    private DialogBox(String message, Image image) {
        Label text = new Label(message);
        text.setWrapText(true);
        text.setMinHeight(Region.USE_PREF_SIZE);
        ImageView picture = new ImageView(image);
        picture.setFitWidth(70);
        picture.setFitHeight(70);
        picture.setPreserveRatio(true);
        setAlignment(Pos.TOP_RIGHT);
        setPadding(new Insets(12));
        setSpacing(10);
        setMinHeight(Region.USE_PREF_SIZE);
        getChildren().addAll(text, picture);
    }

    /** Puts the avatar first and aligns the reply with the left edge. */
    private void flip() {
        var picture = getChildren().remove(1);
        getChildren().addFirst(picture);
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
