package org.howard.edu.lspfinal.question2;

/**
 * Defines an Exception for the TaskMangager of TaskNotFoundException
 */
public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
