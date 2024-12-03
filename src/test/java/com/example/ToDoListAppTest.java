package com.example;

import javafx.stage.Stage;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;
import javafx.scene.control.ListView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListAppTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ToDoListApp().start(stage);
    }

    @Test
    void testAddTask() {
        clickOn("#taskInput");
        write("Test Task 1");
        clickOn("#addButton");
        WaitForAsyncUtils.waitForFxEvents();

        ListView<String> listView = lookup("#taskList").query();
        System.out.println("Список задач після додавання: " + listView.getItems());
        assertFalse(listView.getItems().contains("Test Task 1"), "Завдання не додано до списку!");
    }

    @Test
    void testRemoveTask() {
        clickOn("#taskInput");
        write("Test Task 2");
        clickOn("#addButton");
        WaitForAsyncUtils.waitForFxEvents();

        ListView<String> listView = lookup("#taskList").query();
        System.out.println("Список задач після додавання: " + listView.getItems());
        assertFalse(listView.getItems().contains("Test Task 2"), "Завдання не додано до списку!");

        listView.getSelectionModel().select("Test Task 2");
        clickOn("#deleteButton");
        WaitForAsyncUtils.waitForFxEvents();

        System.out.println("Список задач після видалення: " + listView.getItems());
        assertFalse(listView.getItems().contains(""), "Завдання не видалено!");
    }

    @Test
    public void testMarkTaskAsDone() {
        clickOn("#taskInput");
        write("Test Task 3");
        clickOn("#addButton");

        WaitForAsyncUtils.waitForFxEvents();

        ListView<String> listView = lookup("#taskList").query();
        assertTrue(listView.getItems().contains("Test Task 3"), "Завдання не додано до списку!");

        clickOn("#markAsDoneButton");

        WaitForAsyncUtils.waitForFxEvents();

        assertTrue(listView.getItems().contains("Test Task 3 (Виконано)"), "Завдання не марковано як виконане!");
    }
}
