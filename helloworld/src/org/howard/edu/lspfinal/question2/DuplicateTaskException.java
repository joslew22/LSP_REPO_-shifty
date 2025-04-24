package org.howard.edu.lspfinal.question2;

/**
 * Custom exception thrown when attempting to add a task that already exists.
 */
public class DuplicateTaskException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     * 
     * @param taskName the name of the duplicate task
     */
    public DuplicateTaskException(String taskName) {
        super("Task '" + taskName + "' already exists.");
    }
}