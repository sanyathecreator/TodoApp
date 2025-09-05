module com.sanyathecreator.todoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.compiler;


    opens com.sanyathecreator.todoapp to javafx.fxml;
    exports com.sanyathecreator.todoapp;
}