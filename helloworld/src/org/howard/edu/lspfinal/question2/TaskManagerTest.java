package org.howard.edu.lspfinal.question2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskManagerTest {
    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = new TaskManager();
    }

    @Test
    void testAddTask() throws Exception {
        manager.addTask("Task 1", 1, "TODO");
        assertEquals(1, manager.getTaskByName("Task 1").getPriority());
    }

    @Test
    void testAddDuplicateTask() throws Exception {
        manager.addTask("Task 1", 1, "TODO");
        assertThrows(DuplicateTaskException.class, () -> {
            manager.addTask("Task 1", 2, "IN_PROGRESS");
        });
    }

    @Test
    void testGetNonExistentTask() {
        assertThrows(TaskNotFoundException.class, () -> {
            manager.getTaskByName("Nonexistent");
        });
    }

    @Test
    void testUpdateStatus() throws Exception {
        manager.addTask("Task 1", 1, "TODO");
        manager.updateStatus("Task 1", "DONE");
        assertEquals("DONE", manager.getTaskByName("Task 1").getStatus());
    }

    @Test
    void testUpdateStatusNonExistentTask() {
        assertThrows(TaskNotFoundException.class, () -> {
            manager.updateStatus("Nonexistent", "DONE");
        });
    }
}