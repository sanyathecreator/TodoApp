package com.sanyathecreator.todoapp.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskCardController {
    public Label taskName;
    public Label taskTimeStamp;
    public Label taskStatus;

    public void handleViewTask(ActionEvent actionEvent) {
        System.out.println("Viewing task: " + taskName.getText());
        // TODO: add viewing task logic
    }

    public void setTaskDetails(String name, LocalDateTime timeStamp, String status) {
        taskName.setText(name);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        taskTimeStamp.setText(timeStamp.format(dtf));
        taskStatus.setText(status);
    }
}
