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

        assertTrue(listView.getItems().contains("Test Task 1"), "Завдання не додано до списку!");
    }

    @Test
    void testRemoveTask() {
        clickOn("#taskInput");
        write("Test Task 2");
        clickOn("#addButton");

        WaitForAsyncUtils.waitForFxEvents();

        ListView<String> listView = lookup("#taskList").query();
        assertTrue(listView.getItems().contains("Test Task 2"), "Завдання не додано до списку!");

        clickOn("Test Task 2");
        clickOn("#deleteButton");

        WaitForAsyncUtils.waitForFxEvents();

        assertFalse(listView.getItems().contains("Test Task 2"), "Завдання не видалено!");
    }
}
