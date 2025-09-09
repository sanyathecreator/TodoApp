module com.sanyathecreator.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;
    requires MaterialFX;
    requires javafx.graphics;

    opens com.sanyathecreator.todoapp.controller to javafx.fxml;
    exports com.sanyathecreator.todoapp;
}