package org.howard.edu.lspfinal.question2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages a collection of tasks with operations to add, retrieve, update, and display tasks.
 */
public class TaskManager {
    private final Map<String, Task> tasks = new LinkedHashMap<>();

    /**
     * Adds a new task to the manager.
     * 
     * @param name the task name
     * @param priority the task priority
     * @param status the initial status
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException(name);
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by name.
     * 
     * @param name the name of the task to retrieve
     * @return the requested task
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException(name);
        }
        return task;
    }

    /**
     * Updates the status of an existing task.
     * 
     * @param name the name of the task to update
     * @param newStatus the new status
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        // Use LinkedHashMap to preserve insertion order
        Map<String, List<Task>> tasksByStatus = new LinkedHashMap<>();
        tasksByStatus.put("TODO", new ArrayList<>());
        tasksByStatus.put("IN_PROGRESS", new ArrayList<>());
        tasksByStatus.put("DONE", new ArrayList<>());

        // Group tasks
        for (Task task : tasks.values()) {
            tasksByStatus.get(task.getStatus()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        // Print in predefined order
        for (String status : List.of("TODO", "IN_PROGRESS", "DONE")) {
            List<Task> tasks = tasksByStatus.get(status);
            if (!tasks.isEmpty()) {
                System.out.println(status + ":");
                for (Task task : tasks) {
                    System.out.println("  " + task);
                }
            }
        }
    }
}