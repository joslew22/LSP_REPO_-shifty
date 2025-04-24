package org.howard.edu.lspfinal.question2;

/**
 * Represents a task in the task tracking system.
 */
public class Task {
    private final String name;
    private final int priority;
    private String status;

    /**
     * Constructs a new Task.
     * 
     * @param name the unique name of the task
     * @param priority the priority of the task (lower number = higher priority)
     * @param status the initial status of the task
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Gets the task name.
     * 
     * @return the task name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the task priority.
     * 
     * @return the priority value
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the task status.
     * 
     * @return the current status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the task status.
     * 
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task.
     * 
     * @return formatted task information
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}