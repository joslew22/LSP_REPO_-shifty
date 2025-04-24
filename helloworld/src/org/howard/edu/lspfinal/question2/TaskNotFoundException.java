package org.howard.edu.lspfinal.question2;

/**
 * Custom exception thrown when a requested task cannot be found.
 */
public class TaskNotFoundException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     * 
     * @param taskName the name of the missing task
     */
    public TaskNotFoundException(String taskName) {
        super("Task '" + taskName + "' not found.");
    }
}