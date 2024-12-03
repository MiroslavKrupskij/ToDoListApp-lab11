package com.example;

import javafx.application.Platform;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.util.WaitForAsyncUtils;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListAppTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        new ToDoListApp().start(stage);
    }

    @Test
    void testAddTask() throws InterruptedException {
        clickOn(".text-field");
        write("Test Task 1");
        clickOn("#addButton");

        WaitForAsyncUtils.waitForFxEvents();

        ListView<String> listView = lookup(".list-view").query();

        assertTrue(listView.getItems().contains("Test Task 1"));
    }

    @Test
    void testRemoveTask() throws InterruptedException {
        clickOn(".text-field");
        write("Test Task 2");
        clickOn("#addButton");

        WaitForAsyncUtils.waitForFxEvents();

        ListView<String> listView = lookup(".list-view").query();
        clickOn("Test Task 2");

        clickOn("#deleteButton");

        WaitForAsyncUtils.waitForFxEvents();

        assertFalse(listView.getItems().contains("Test Task 2"));
    }
}

