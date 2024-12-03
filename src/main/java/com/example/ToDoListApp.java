package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ToDoListApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        TextField taskInput = new TextField();
        Button addButton = new Button("Додати");
        addButton.setId("addButton");
        Button deleteButton = new Button("Видалити");
        deleteButton.setId("deleteButton");

        addButton.setOnAction(e -> {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                listView.getItems().add(task);
                taskInput.clear();
            }
        });

        deleteButton.setOnAction(e -> {
            String selected = listView.getSelectionModel().getSelectedItem();
            listView.getItems().remove(selected);
        });

        VBox layout = new VBox(10, listView, taskInput, addButton, deleteButton);
        Scene scene = new Scene(layout, 300, 400);

        primaryStage.setTitle("To Do List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
