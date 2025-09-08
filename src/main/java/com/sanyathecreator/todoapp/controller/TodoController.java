package com.sanyathecreator.todoapp.controller;

import com.sanyathecreator.todoapp.dto.TaskDTO;
import com.sanyathecreator.todoapp.managers.TaskList;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class TodoController {
    @FXML
    public MFXComboBox statusComboBox;
    @FXML
    public VBox taskListVBox;
    private TaskList taskList;

    public void initialize() {
        taskList = new TaskList();
        statusComboBox.getItems().addAll("All", "ToDo", "In Progress", "Done");
        statusComboBox.setValue("All");
    }

    @FXML
    public void handleAddTask(ActionEvent actionEvent) {
        showAddTaskDialog();
    }

    private void showAddTaskDialog() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/com/sanyathecreator/todoapp/task_add_dialog.fxml"));
            VBox dialogPane = loader.load();

            TaskAddDialogController dialogController = loader.getController();
            dialogController.setMainController(this);

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Add New Task");
            dialogStage.initModality(Modality.APPLICATION_MODAL); // User can interact only with this dialog
            Scene scene = new Scene(dialogPane);
            String css = this.getClass().getResource("/com/sanyathecreator/todoapp/addtaskstyles.css").toExternalForm();
            scene.getStylesheets().add(css);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTaskFromDialog(String title, String description) {
        addTask(title, description, LocalDateTime.now(), "ToDo");
    }

    private void addTask(String title, String description, LocalDateTime dateAdded, String status) {
        TaskDTO task = new TaskDTO(title, description, dateAdded, status);
        taskList.addTask(task);
        displayTask(task);
    }

    private void displayTask(TaskDTO task) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/com/sanyathecreator/todoapp/task-card.fxml"));
            HBox taskCard = loader.load();
            TaskCardController taskCardController = loader.getController();
            taskCardController.setTaskDetails(task.getTitle(), task.getDateAdded(), task.getStatus());

            taskListVBox.getChildren().add(taskCard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
