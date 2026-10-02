# JavaFX tutorial

Implementation of [SE-EDU's JavaFX tutorial](https://se-education.org/guides/tutorials/javaFx.html),
using its [starter repository](https://github.com/se-edu/javafx-tutorial).

Use Java 25. On this Mac:

```sh
source ~/.sdkman/bin/sdkman-init.sh
sdk use java 25.0.3.fx-zulu
./gradlew run
```

Part 1 adds the tutorial's JavaFX dependencies for Windows, macOS, and Linux,
a separate `Launcher`, and a Hello World window. `Stage` is the window,
`Scene` holds its contents, and `Label` is the visible node.

Codex assisted with implementing, documenting, and checking the tutorial.

## Part 2 — Controls and layout

`AnchorPane` positions the input and Send button beneath a `ScrollPane`.
A `VBox` stacks chat rows; each reusable `DialogBox` is an `HBox` with a
wrapping `Label` and an `ImageView`. This checkpoint displays a sample message.

The `DaUser.png` and `DaDuke.png` images come from
[SE-EDU's tutorial assets](https://github.com/se-edu/guides/tree/master/tutorials/images/javafx).

## Part 3 — Events and replies

Enter and Send use the same handler. Each submission adds a user dialog and
Duke's echo response, clears the field, and restores keyboard focus. A height
listener scrolls to the latest message while allowing manual scrolling later.
The two dialog factory methods position the speaker's avatar on opposite sides.

## Part 4 — FXML and controllers

`Main` loads `view/MainWindow.fxml`. Its `fx:controller` names `MainWindow`,
and each `fx:id` identifies the matching `@FXML` field. Both input controls
reference `#handleUserInput`. `DialogBox.fxml` instead uses `fx:root`: each
`DialogBox` instance sets itself as the loader's root and controller.

These FXML files can be opened in Scene Builder. Keep the JavaFX namespace at
version 17 after saving so it matches the tutorial's dependency configuration.

## Part 5 — Resizing and CSS

Implemented these tutorial tweaks:

- Anchor the input to the bottom, left, and right so its width follows the window.
- Anchor Send to the bottom right.
- Anchor all four edges of the scroll pane and fit its contents to the width.
- Set a minimum window width and height.
- Link separate main-window and dialog stylesheets from FXML.
- Flip reply bubble corners with the `reply-label` style class.
- Add padding inside bubbles and margins between text and avatars.
- Use rounded borders with matching background corners.
- Use hex/RGBA colors, shared looked-up colors, a gradient, `derive`, and `ladder`.
- Style hover, pressed, focused, and disabled control states.
- Add avatar shadows.
- Style the scroll bar and hide its increment/decrement buttons.

This is the tutorial's echo chatbot: it does not manage or save tasks.
The optional task-command colors and background-image experiments are not implemented.
The FXML was edited directly; Scene Builder is not installed on the development Mac.

## Build and try it

```sh
./gradlew clean build shadowJar
java -jar build/libs/javafx-tutorial-duke.jar
```

Open this folder as a Gradle project in IntelliJ and select JDK 25 for both the
project SDK and Gradle JVM. Run `Launcher.main()` or the Gradle `run` task.

Try both Enter and Send. Check that each adds two bubbles, that the input clears,
and that the avatars face opposite sides. Submit a long paragraph, fill the chat
until it scrolls, scroll upward, and then send another message. Resize the window
to verify that the text wraps and the input controls remain visible.
