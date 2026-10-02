# JavaFX tutorial — Part 3

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
