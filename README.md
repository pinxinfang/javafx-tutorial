# JavaFX tutorial — Part 1

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
