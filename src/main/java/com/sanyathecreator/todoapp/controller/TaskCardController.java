package com.sanyathecreator.todoapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskCardController {
    public Label taskName;
    public Label taskTimeStamp;
    public Label taskStatus;

    public void handleViewTask(ActionEvent actionEvent) {
        System.out.println("Viewing task: " + taskName.getText());
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/com/sanyathecreator/todoapp/task_view_dialog.fxml"));
            VBox dialogPane = loader.load();

            TaskViewDialogController dialogController = loader.getController();
            // dialogController.setMainController(this);

            Stage dialogStage = new Stage();
            dialogStage.setTitle(taskName.getText());
            dialogStage.initModality(Modality.APPLICATION_MODAL); // User can interact only with this dialog
            Scene scene = new Scene(dialogPane);
            // String css = this.getClass().getResource("/com/sanyathecreator/todoapp/addtaskstyles.css").toExternalForm();
            // scene.getStylesheets().add(css);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTaskDetails(String name, LocalDateTime timeStamp, String status) {
        taskName.setText(name);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        taskTimeStamp.setText(timeStamp.format(dtf));
        taskStatus.setText(status);
        applyStatusColor(status);
    }

    private void applyStatusColor(String status) {
        switch (status) {
            case "ToDo":
                taskStatus.setStyle("-fx-text-fill: grey;");
                break;
            case "In Progress":
                taskStatus.setStyle("-fx-text-fill: orange;");
                break;
            case "Done":
                taskStatus.setStyle("-fx-text-fill: green;");
                break;
            default:
                taskStatus.setStyle("-fx-text-fill: black;");
                break;
        }
    }
}
