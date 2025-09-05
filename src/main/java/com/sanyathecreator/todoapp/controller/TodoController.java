package com.sanyathecreator.todoapp.controller;

import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDateTime;

public class TodoController {
    @FXML
    public MFXComboBox statusComboBox;
    @FXML
    public VBox taskList;

    public void initialize() {
        statusComboBox.getItems().addAll("All", "ToDo", "In Progress", "Done");
        statusComboBox.setValue("All");
        // Dummy data
        addTask("Create a JavaFX Project", LocalDateTime.now().minusMinutes(3), "ToDo");
        addTask("Learn React", LocalDateTime.now().minusMinutes(9), "In Progress");
        addTask("Create a TodoApp", LocalDateTime.now().minusHours(3).minusMinutes(17), "ToDo");
    }

    @FXML
    public void handleAddTask(ActionEvent actionEvent) {
        addTask("New Task", LocalDateTime.now(), "Todo");
    }

    private void addTask(String name, LocalDateTime timeStamp, String status) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/com/sanyathecreator/todoapp/task-card.fxml"));
            HBox taskCard = loader.load();
            TaskCardController taskCardController = loader.getController();
            taskCardController.setTaskDetails(name, timeStamp, status);

            taskList.getChildren().add(taskCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
