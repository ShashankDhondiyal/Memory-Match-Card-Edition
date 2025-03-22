module com.game {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.game to javafx.fxml;
    exports com.game;
}
